package com.inandout.real_rider.decoration;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author minfrank
 * @since 2023/11/04
 * 사용법 예시
 * recyclerview.addItemDecoration(new RecyclerViewDecoration(60));
 */
public class RecyclerContentPaddingDecoration extends RecyclerView.ItemDecoration {

    private final int divHeight;

    public RecyclerContentPaddingDecoration(int divHeight)
    {
        this.divHeight = divHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = divHeight;
    }
}
