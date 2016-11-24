上篇[Android ListView中复杂数据流的高效渲染](http://www.jianshu.com/p/59b524c94bea)文章中介绍如何高效利用ListView的缓存进行渲染。之后有挺多同学有些疑惑，希望可以有一个demo，于是利用业余时间把demo橹出来了，如果有什么问题大家可以评论或者在**[ComplexDataStream issue](https://github.com/wutongke/ComplexDataStream/issues)**中提issue。这里贴一下demo的地址：**[ComplexDataStream](https://github.com/wutongke/ComplexDataStream)**。另个人觉得这个思路实际增加了代码复杂度，在逻辑上并不高效，于是在题目中加了引号，但是实测一个复杂列表中可以节约10-20m的内存，这一点是很有诱惑力的。下面结合代码介绍一下。
## 代码结构
![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1407686-bf0f38578093cbb4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
*  Model
model中是所有的原始数据类，这里为了方便，每种数据的名字实际包含了需要展示的模型：如CardWithTitleItem数据实际需要展示一个标题和一个卡片，HeaderImageCardItem需要展示一个头部、图片、卡片。

![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1407686-e226767884d28815.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)

![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1407686-9410c420d9caa634.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)

*  Adapter
Adapter中放置了adapter和各种类型的holder，这里把多种数据类型拆分成了card、divider、header、image、link、text、title，并为每种类型设置了相应的布局。

* Util
Util中设置如何transform数据到相应的展示模版，以及解决按压效果的问题。

## 代码思路
我们的目的是将复杂的数据类型进行拆分，从而达到细颗粒的view复用，降低内存占用。
1. 确定拆分后的展示类型，这里使用了一个enum类型：
```
public enum ItemType {
    TITLE,
    CARD,
    HEADER,
    IMAGE,
    TEXT,
    LINK,
    DIVIDER
}
```
2. transform数据到模板，拆分后一个数据类型对应多个模板，这里我们使用hashmap建立数据到模板的影射关系：
```
private static Map<Class, List<ItemType>> map = new HashMap<>();
```
```
    public static List<ItemWrap> getTransformedItem(List<BaseItem> baseItems) {
        List<ItemWrap> itemWraps = new ArrayList<>();
        for (BaseItem baseItem : baseItems) {
            for (ItemType itemType : map.get(baseItem.getClass())) {
                ItemWrap temp = new ItemWrap(baseItem, itemType);
                itemWraps.add(temp);
                baseItem.itemWraps.add(temp);
            }
            ItemWrap divider = new ItemWrap(baseItem, ItemType.DIVIDER);
            itemWraps.add(divider);
            baseItem.itemWraps.add(divider);
        }
        return itemWraps;
    }
```
getTransformedItem方法将原始数据进行拆分，注意每种原始数据类型中都要加入divider模板，用于展示ListView的分割线。
3. 根据不同的展示类型提供不同的view：
```
public static View createItemView(ItemType itemType) {
        View view = null;
        BaseHolder baseHolder = null;
        switch (itemType) {
            case TITLE:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.title_item, null);
                baseHolder = new TitleHolder();
                break;
            case CARD:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.card_item, null);
                baseHolder = new CardHolder();
                break;
            case TEXT:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.text_item, null);
                baseHolder = new TextHolder();
                break;
            case IMAGE:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.image_item, null);
                baseHolder = new ImageHolder();
                break;
            case LINK:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.link_item, null);
                baseHolder = new LinkHolder();
                break;
            case HEADER:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.header_item, null);
                baseHolder = new HeaderHolder();
                break;
            case DIVIDER:
                view = LayoutInflater.from(_Application.applicationContext).inflate(R.layout.divider_item, null);
                baseHolder = new DividerHolder();
                break;
        }
        baseHolder.setup(view);
        view.setTag(baseHolder);
        return view;
    }
```
4. 按压效果的实现
对数据进行拆分后，有一个坑就是按压效果的实现，这个时候listView中的每个item都不是一个完整的原始数据，要实现一个整体的按压效果，demo的思路是：
![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1407686-f1cace9016757970.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
当按压任意一个view时，通知相应的item，改变item包含的所有view的状态。具体实现时定义了一个BackgroundLinearLayout：
```
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            if (mListener != null) {
                mListener.onStatePress(false);
            }
        } else if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (mListener != null) {
                mListener.onStatePress(true);
            }
        } else if (ev.getAction() == MotionEvent.ACTION_CANCEL) {
            if (mListener != null) {
                mListener.onStatePress(false);
            }
        }
        super.dispatchTouchEvent(ev);
        return true;
    }
```
可以完成view按压的回调。
但是每个holder需要如思路图所示绑定到View，绑定可以在adapter的getview中完成。：
```
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemWrap itemWrap = (ItemWrap) getItem(position);
        if(convertView == null){
            convertView = ItemWrapHelper.getItemView(itemWrap.getItemType());
        }else {
            ((ItemWrap)(convertView.getTag(R.string.tag_key))).unBindView();
        }
        convertView.setTag(R.string.tag_key, itemWrap);
        BaseHolder baseHolder = (BaseHolder) convertView.getTag();
        baseHolder.render(itemWrap.getBaseItem());
        itemWrap.bindView(convertView);
        return convertView;
    }
```
基本demo就完成了，按压效果如图：
![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1407686-f0aab23b7a1a8359.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/800)
## 总结
由于主要展现功能，界面没有进行太多调整，另外mock数据是复制了部分［one 一个]应用的数据，表示感谢。代码中有什么问题，或者有什么不合理的地方，感兴趣的同学可以建立pull request，欢迎讨论。项目地址**[ComplexDataStream](https://github.com/wutongke/ComplexDataStream)**。
