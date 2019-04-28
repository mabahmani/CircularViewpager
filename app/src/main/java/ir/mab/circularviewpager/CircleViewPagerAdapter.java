package ir.mab.circularviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CircleViewPagerAdapter extends PagerAdapter {
    private String [] contents;
    private Context context;

    CircleViewPagerAdapter(String[] contents, Context context) {
        this.contents = contents;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView textView = new TextView(context);
        textView.setText(contents[position%contents.length]);
        container.addView(textView);

        return textView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);

        container.removeView((View) object);
    }
}
