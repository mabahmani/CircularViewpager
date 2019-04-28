package ir.mab.circularviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String[] content = {"text zero", "text one", "text two"};
    CustomViewPager viewPager;
    Button left,right;
    boolean allowLeft = true;
    boolean allowRight = true;

    int middleMaxValue = Integer.MAX_VALUE / 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left = findViewById(R.id.left_btn);
        right = findViewById(R.id.right_btn);
        viewPager = findViewById(R.id.circular_viewpager);
        viewPager.setAdapter(new CircleViewPagerAdapter(content,this));
        viewPager.setCurrentItem(middleMaxValue);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allowLeft && allowRight) {
                    System.out.println("0");
                    allowLeft = false;
                    viewPager.setAllowedSwipeDirection(SwipeDirection.right);
                }

                else if (!allowLeft && allowRight){
                    System.out.println("1");
                    allowLeft = true;
                    viewPager.setAllowedSwipeDirection(SwipeDirection.all);
                }

                if(allowLeft && !allowRight) {
                    System.out.println("2");
                    allowLeft = false;
                    viewPager.setAllowedSwipeDirection(SwipeDirection.none);
                }

                else if(!allowLeft && !allowRight) {
                    System.out.println("3");
                    allowLeft = true;
                    viewPager.setAllowedSwipeDirection(SwipeDirection.left);
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allowRight && allowLeft) {
                    allowRight = false;
                    viewPager.setAllowedSwipeDirection(SwipeDirection.left);
                }

                else if (!allowRight && allowLeft){
                    allowRight = true;
                    viewPager.setAllowedSwipeDirection(SwipeDirection.all);
                }

                if(allowRight && !allowLeft) {
                    allowRight = false;
                    viewPager.setAllowedSwipeDirection(SwipeDirection.none);
                }

                else if(!allowRight && !allowLeft) {
                    allowRight = true;
                    viewPager.setAllowedSwipeDirection(SwipeDirection.right);
                }
            }
        });

    }
}
