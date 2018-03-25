package com.whartonsummit.android_app.pwcs_android.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.whartonsummit.android_app.pwcs_android.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhileizheng on 3/25/18.
 */

public class FaqExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> faqHeaders;
    private HashMap<String, String> faqAnswers;

    public FaqExpandableAdapter(Context context, List<String> headers,
                                HashMap<String, String> questionAnswers) {
        this.context = context;
        this.faqHeaders = headers;
        this.faqAnswers = questionAnswers;
    }

    @Override
    public int getGroupCount() {
        return faqHeaders.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int headerPosition) {
        return this.faqHeaders.get(headerPosition);
    }

    @Override
    public Object getChild(int headerPosition, int childPosition) {
        return faqAnswers.get(this.faqHeaders.get(headerPosition));
    }

    @Override
    public long getGroupId(int headerPosition) {
        return headerPosition;
    }

    @Override
    public long getChildId(int headerPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int headerPosition, boolean isExpandable, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(headerPosition);
        if (convertView == null) {
            LayoutInflater headerInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = headerInflater.inflate(R.layout.faq_list_group, null);
        }
        TextView headerText = (TextView) convertView.findViewById(R.id.header_text);
        headerText.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int headerPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(headerPosition, childPosition);
        if (convertView == null) {
            LayoutInflater childInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = childInflater.inflate(R.layout.faq_list_item, null);
        }
        TextView childTextView = (TextView) convertView.findViewById(R.id.child_text);
        childTextView.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
