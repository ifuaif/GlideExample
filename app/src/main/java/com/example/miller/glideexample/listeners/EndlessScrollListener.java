package com.example.miller.glideexample.listeners;

import android.widget.AbsListView;

/**
 * Created by zhecky on 05.06.17.
 */

public class EndlessScrollListener implements AbsListView.OnScrollListener {
    private int firstVisibleItem;
    private int visibleItemCount;
    private int scrollState;
    private boolean isLoading;
    private LoadMoreListener loadMoreListener;
    private int totalItemCount;

    public EndlessScrollListener(LoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        this.scrollState = scrollState;
        this.isScrollCompleted();
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.firstVisibleItem = firstVisibleItem;
        this.visibleItemCount = visibleItemCount;
        this.totalItemCount = totalItemCount;

    }

    private void isScrollCompleted() {
        final int lastItem = firstVisibleItem + visibleItemCount;
        if (lastItem >= totalItemCount - 5 && scrollState == SCROLL_STATE_IDLE) {

            if(!isLoading){
                isLoading = true;
                loadMoreListener.loadMore();
            }
        }
    }

    public void loadingFinished() {
        isLoading = false;
    }
}
