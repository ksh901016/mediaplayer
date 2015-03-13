package com.example.playaudio;

import java.util.*;

import android.content.*;
import android.view.*;
import android.widget.*;

public class ListView {

	// 리스트뷰에 출력할 항목
	class MyItem {
		MyItem(int aIcon, String aName) {
			Icon = aIcon;
			Name = aName;
		}

		int Icon;
		String Name;
	}

	// 어댑터 클래스
	class MyListAdapter extends BaseAdapter {
		Context maincon;
		LayoutInflater inflater;
		ArrayList<MyItem> arSrc;
		int layout;

		public MyListAdapter(Context context, int alayout,
				ArrayList<MyItem> aarSrc) {
			maincon = context;
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			arSrc = aarSrc;
			layout = alayout;
		}

		@Override
		public int getCount() {
			return arSrc.size();
		}

		@Override
		public Object getItem(int position) {
			return arSrc.get(position).Name;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final int pos = position;
			if (convertView == null) {
				convertView = inflater.inflate(layout, parent, false);
			}
			ImageView img = (ImageView) convertView.findViewById(R.id.img);
			img.setImageResource(arSrc.get(position).Icon);

			TextView txt = (TextView) convertView.findViewById(R.id.text);
			txt.setText(arSrc.get(position).Name);

			Button btn = (Button) convertView.findViewById(R.id.btn);
			btn.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) {
					String str = arSrc.get(pos).Name + "를 주문합니다.";
					Toast.makeText(maincon, str, Toast.LENGTH_SHORT).show();
				}

			});
			return convertView;
		}
	}
}
