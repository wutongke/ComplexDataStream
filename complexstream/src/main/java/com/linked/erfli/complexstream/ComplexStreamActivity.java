package com.linked.erfli.complexstream;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.linked.complexstream.R;
import com.linked.complexstream.databinding.ActivityComplexStreamBinding;
import com.linked.erfli.complexstream.Adapter.ComplexStreamAdapter;
import com.linked.erfli.complexstream.Model.BaseItem;
import com.linked.erfli.complexstream.Model.Card;
import com.linked.erfli.complexstream.Model.CardWithTitleItem;
import com.linked.erfli.complexstream.Model.Header;
import com.linked.erfli.complexstream.Model.HeaderCardItem;
import com.linked.erfli.complexstream.Model.HeaderImageCardItem;
import com.linked.erfli.complexstream.Model.HeaderImageItem;
import com.linked.erfli.complexstream.Model.HeaderTextCardItem;
import com.linked.erfli.complexstream.Model.HeaderTextImageViewItem;
import com.linked.erfli.complexstream.Model.HeaderTextItem;
import com.linked.erfli.complexstream.Model.HeaderTextWithLinkItem;
import com.linked.erfli.complexstream.Model.HeaderTextWithTitleItem;
import com.linked.erfli.complexstream.Util.ItemWrapHelper;

import java.util.ArrayList;
import java.util.List;

public class ComplexStreamActivity extends AppCompatActivity {
    ActivityComplexStreamBinding activityComplexStreamBinding;
    ComplexStreamAdapter complexStreamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComplexStreamBinding = DataBindingUtil.setContentView(this, R.layout.activity_complex_stream);
        complexStreamAdapter = new ComplexStreamAdapter();
        complexStreamAdapter.setTransformedItemList(ItemWrapHelper.getTransformedItem(mackData()));
        activityComplexStreamBinding.dataList.setAdapter(complexStreamAdapter);


    }

    private List<BaseItem> mackData() {

        List<Header> headerList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Header header = new Header(avatars[i], names[i], ages[i]);
            headerList.add(header);
        }

        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Card card = new Card(images[(int) (Math.random() * 6)], texts[(int) (Math.random() * 13)]);
            cardList.add(card);
        }

        List<List<String>> imagesList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int imagesCount = 1 + (int) (Math.random() * 8);
            List<String> imagesData = new ArrayList<>();
            for (int j = 0; j < imagesCount; j++) {
                imagesData.add(images[(int) (Math.random() * 6)]);
            }
            imagesList.add(imagesData);
        }

        List<BaseItem> baseItems = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            CardWithTitleItem cardWithTitleItem = new CardWithTitleItem(titles[(int) (Math.random() * 13)], cardList.get((int) (Math.random() * 10)));
            baseItems.add(cardWithTitleItem);

            HeaderCardItem headerCardItem = new HeaderCardItem(headerList.get((int) (Math.random() * 6)), cardList.get((int) (Math.random() * 10)));
            baseItems.add(headerCardItem);

            HeaderImageCardItem headerImageCardItem = new HeaderImageCardItem(headerList.get((int) (Math.random() * 6)),
                    imagesList.get((int) (Math.random() * 10)), cardList.get((int) (Math.random() * 10)));
            baseItems.add(headerImageCardItem);

            HeaderImageItem headerImageItem = new HeaderImageItem(headerList.get((int) (Math.random() * 6)),
                    imagesList.get((int) (Math.random() * 10)));
            baseItems.add(headerImageItem);

            HeaderTextCardItem headerTextCardItem = new HeaderTextCardItem(headerList.get((int) (Math.random() * 6)),
                    texts[(int) (Math.random() * 13)],
                    cardList.get((int) (Math.random() * 10)));
            baseItems.add(headerTextCardItem);

            HeaderTextImageViewItem headerTextImageViewItem = new HeaderTextImageViewItem(headerList.get((int) (Math.random() * 6)),
                    texts[(int) (Math.random() * 13)],
                    imagesList.get((int) (Math.random() * 10)));
            baseItems.add(headerTextImageViewItem);

            HeaderTextItem headerTextItem = new HeaderTextItem(headerList.get((int) (Math.random() * 6)),
                    texts[(int) (Math.random() * 13)]);
            baseItems.add(headerTextItem);

            HeaderTextWithLinkItem headerTextWithLinkItem = new HeaderTextWithLinkItem(headerList.get((int) (Math.random() * 6)),
                    texts[(int) (Math.random() * 13)], "查看更多");
            baseItems.add(headerTextWithLinkItem);

            HeaderTextWithTitleItem headerTextWithTitleItem = new HeaderTextWithTitleItem(headerList.get((int) (Math.random() * 6)),
                    texts[(int) (Math.random() * 13)], titles[(int) (Math.random() * 13)]);
            baseItems.add(headerTextWithTitleItem);
        }
        return baseItems;
    }

    String[] names = {"康若雪 ", "李维北", "张寒寺", "康夫", "远子", "同盟",};
    int[] ages = {18, 27, 34, 22, 23, 29};
    String[] avatars = {"http://image.wufazhuce.com/FigdxQd9YyuiYsl-hP6R_DSeQutt",
            "http://image.wufazhuce.com/FpxK_69dEyDmVThtzxgiKz0iV4bD",
            "http://image.wufazhuce.com/FimU8jwErFv4H1mym9tSpbBamOyP",
            "http://image.wufazhuce.com/FlJ2uKL9qGrmdsyWZr_CmOwg_kjt",
            "http://image.wufazhuce.com/FjeGV_ZCnP7ttQxbCrMZvrRVchsF",
            "http://image.wufazhuce.com/FtYBiYEg2U6ggmLKgBZOsTKRqmJG"
    };

    String[] images = {
            "http://image.wufazhuce.com/FpItlTVYZdGk8BsypyOTiIacLEZR",
            "http://image.wufazhuce.com/FpaT3AmWm8is-jzFdQe6HWIENAd1",
            "http://image.wufazhuce.com/Fns2IT8gF9_iGDyFtz3npG6XpdVV",
            "http://image.wufazhuce.com/FrrnnK1yaLPLEixP4pz_UeiGAQT6",
            "http://image.wufazhuce.com/Fuf1P2el0pdPBhIvG1PzqHh51Vr-",
            "http://image.wufazhuce.com/FoiXs9GyqCUf5o-Vhj9q67Q839FF",
    };

    String[] texts = {
            "对相爱的人来说，对方的心才是最好的房子。”by村上春树",
            "在这个纷乱的世界中，只有火车才能带给我一丝平静。” from《生活大爆炸》",
            "对不起，我就要忘记你了……",
            "孤独从来就不会毁掉一个人。把自己的头奋命塞进一个不适合自己的圈子，佯装自己不孤独才会毁掉一个人",
            "只希望在这个看脸的时代能不要脸地活着。",
            "不是身边的不是最爱，而是最爱的已经不在身边。",
            "这就是我们的工作不是吗？给想要在贫瘠的生活中寻找刺激的人一次完整的恐怖之旅。 ",
            "我最近常常发现，只有通过否定他人的生活才能给自己找到活下去的勇气。",
            "哪怕自己已经认错了，在对方提出分手的瞬间，就不要去挽回或者解释了。",
            "所有曾经与他患难与共的朋友，怜爱垂恩的亲人，都会和他形同陌路。",
            "“也许他待会儿就回来了，也许他永远也不会回来了。”",
            "这才是真实世界，之前那不过是一个“美梦”，足够的充值换来“美梦成真”，越是高级的梦想越是需要付出更多价值。",
            "每次当有人喊她，大奶奶，我不知为何总有一种血脉膨胀的感觉……可能是真的太美了。",
    };
    String[] titles = {
            "村上春树",
            "《生活大爆炸》",
            "对不起",
            "自己的圈子",
            "看脸的时代",
            "已经不在身边。",
            "我们的工作",
            "活下去的勇气。",
            "挽回或者解释",
            "所有曾经",
            "不会回来了",
            "这才是真实世界",
            "太美了。",
    };
}
