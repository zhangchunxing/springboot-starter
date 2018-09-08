package com.zhangcx.springboot;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhangchunxing
 * @create: 2018-08-10
 */
public class Lists {
	public static void main(String[] args) {


		List<Object> list1 = new ArrayList<>();
		list1.add("1");
		list1.add("1");
		List<Object> list2 = new ArrayList<>();
		list2.add("2");
		list2.add("2");
		List<Object> list3 = new ArrayList<>();
		list3.add("3");
		list3.add("3");
		//通过这样的方式，使代码更加优雅，更加清晰，调用方无需理解循环细节
		Lists.forEach(list1,list2,list3).then(new Each() {
			@Override
			public void test(Object... items) {
				System.out.println(items[0]+"\t"+items[1]+"\t"+items[2]);
			}
		});
	}

	private List[] lists;

	public static class Builder{
		private List[] lists;

		public Builder setLists(List[] lists){
			this.lists = lists;
			return this;
		}
		//通过构建者实例化Lists类
		public Lists build(){
			return new Lists(this);
		}
	}

	private Lists(Builder builder){
		this.lists = builder.lists;
	}

	/**
	 *
	 * @param lists
	 * @return
	 */
	public static Lists forEach(List...lists){
		return new Lists.Builder().setLists(lists).build();
	}

	public void then(Each each){
		if(null != lists && lists.length > 0){
			List list1 = lists[0];
			for (int i = 0;i < list1.size() ;i++){
				List list2 = lists[1];
				for(int j = 0;j < list2.size();j++){
					List list3 = lists[2];
					for(int k = 0;k < list3.size();k++){
						each.test(list1.get(i),list2.get(j),list3.get(k));
					}
				}
			}
		}
	}
	//设置观察者
	public interface Each{

		void test(Object...items);

	}
}
