package pers.liujicheng.leetcode.hard.distanceLimitedPathsExist;

import java.util.*;
import java.util.stream.Collectors;

public class DistanceLimitedPathsExist {

//	public static void main(String[] args) {
//		List<String> strings = FileUtil.readLines("C:\\Users\\KEVIN-JC\\Desktop\\tttt.json", Charset.defaultCharset());
//
//		String line1 = strings.get(1);
//		String line2 = strings.get(2);
//
//		JSONArray objects1 = JSONObject.parseArray(line1);
//		int[][] arr1 = new int[objects1.size()][3];
//		for (int i = 0; i < objects1.size(); i++) {
//			JSONArray objects = (JSONArray) objects1.get(i);
//			arr1[i][0] = (Integer)objects.get(0);
//			arr1[i][1] = (Integer)objects.get(1);
//			arr1[i][2] = (Integer)objects.get(2);
//		}
//
//		JSONArray objects2 = JSONObject.parseArray(line2);
//		int[][] arr2 = new int[objects2.size()][3];
//		for (int i = 0; i < objects2.size(); i++) {
//			JSONArray objects = (JSONArray) objects2.get(i);
//			arr2[i][0] = (Integer)objects.get(0);
//			arr2[i][1] = (Integer)objects.get(1);
//			arr2[i][2] = (Integer)objects.get(2);
//		}
//
//		long start = System.currentTimeMillis();
//		boolean[] booleans = distanceLimitedPathsExist(Integer.valueOf(strings.get(0)), arr1, arr2);
//		System.out.println("spend time: " + (System.currentTimeMillis() - start));
//		System.out.println(JSONObject.toJSONString(booleans));
//
//	}

	public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
		boolean[] result = new boolean[queries.length];
		List<int[]> collect = Arrays.stream(queries).collect(Collectors.toList());

		// 排序
		edgeList = sortList(edgeList);
		queries = sortList(queries);

		// 游标
		int edgeIdx = 0;
		int areaIdx = 0;

		// 构建map
		Map<Integer, Integer> buildMap = new HashMap<>(edgeList.length + 1);
		Map<String, Boolean> resultMap = new HashMap<>(queries.length);
		Set<Integer> queryOtherIdxSet = new HashSet<>();
		for (int i = 0; i < queries.length; i++) {
			queryOtherIdxSet.add(i);
		}

		// 开始构建点
		do {
			int[] edgeP = edgeList[edgeIdx];
			Integer startArea = buildMap.get(edgeP[0]);
			Integer endArea = buildMap.get(edgeP[1]);

			int[] ints = optAreaIdx(areaIdx, buildMap, edgeP, startArea, endArea);
			areaIdx = ints[0];

			// 校验下一个点
			Iterator<Integer> iterator = queryOtherIdxSet.iterator();
			while (iterator.hasNext()) {
				Integer next = iterator.next();
				int nextStart = queries[next][0];
				int nextEnd = queries[next][1];
				Integer nextStartArea = buildMap.get(nextStart);
				Integer nextEndArea = buildMap.get(nextEnd);
				if (null != nextStartArea && null != nextEndArea && nextStartArea.equals(nextEndArea)) {
					if (edgeP[2] < queries[next][2]) {
						resultMap.put(queries[next][0] + "-" + queries[next][1] + "-" + queries[next][2], true);
						iterator.remove();
					} else {
						resultMap.put(queries[next][0] + "-" + queries[next][1] + "-" + queries[next][2], false);
						iterator.remove();
					}
				}
			}

			edgeIdx++;
		} while (edgeList.length > edgeIdx && queryOtherIdxSet.size() > 0);

		for (int i = 0; i < collect.size(); i++) {
			int[] originArr = collect.get(i);
			Boolean aBoolean = resultMap.get(originArr[0] + "-" + originArr[1] + "-" + originArr[2]);
			result[i] = null == aBoolean ? false : aBoolean;
		}

		return result;
	}

	private static int[] optAreaIdx(int areaIdx, Map<Integer, Integer> buildMap, int[] edgeP, Integer startArea, Integer endArea) {
		// 两个点都是null
		if (null == startArea && null == endArea) {
			buildMap.put(edgeP[0], areaIdx);
			buildMap.put(edgeP[1], areaIdx);
			return new int[]{++areaIdx, areaIdx};
		}
		// 两个点都不是null
		if (null != startArea && null != endArea) {
			int lesser = startArea;
			int greater = endArea;
			if (endArea < startArea) {
				lesser = endArea;
				greater = startArea;
			}
			for (Map.Entry<Integer, Integer> entry : buildMap.entrySet()) {
				if (entry.getValue().equals(greater)) {
					entry.setValue(lesser);
				}
			}
			return new int[]{areaIdx, lesser};
		}
		// 两个点有一个null
		int[] ints = {areaIdx, 0};
		if (null != endArea) {
			buildMap.put(edgeP[0], endArea);
			ints[1] = endArea;
		}
		if (null != startArea) {
			buildMap.put(edgeP[1], startArea);
			ints[1] = startArea;
		}
		return ints;
	}

	public static int[][] sortList(int[][] list) {
		int[] temp;
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j][2] > list[j + 1][2]) {
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
		return list;
	}
}
