/*
 * Author: Minho Kim (ISKU)
 * Date: September 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://programmers.co.kr/learn/courses/30/lessons/42893
 */

import java.util.*;

class Solution {

	private Page[] page;
	private Map<String, Integer> urls;

	public int solution(String word, String[] pages) {
		int N = pages.length;
		word = word.toLowerCase();

		page = new Page[N];
		urls = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String html = pages[i].toLowerCase();
			String url = getUrl(html);
			page[i] = new Page(i, html);
			urls.put(url, i);
		}

		for (int i = 0; i < N; i++)
			page[i].defaultScore = countWord(word, page[i].html);
		for (int i = 0; i < N; i++)
			page[i].externalLinks = countLink(i, page[i].html);
		for (int i = 0; i < N; i++)
			page[i].linkScore = getLinkScore(i);
		for (int i = 0; i < N; i++)
			page[i].matchingScore = page[i].defaultScore + page[i].linkScore;

		Arrays.sort(page, new Comparator<Page>() {
			@Override
			public int compare(Page o1, Page o2) {
				if (o1.matchingScore == o2.matchingScore)
					return Integer.compare(o1.index, o2.index);
				return Double.compare(o2.matchingScore, o1.matchingScore);
			}
		});

		return page[0].index;
	}

	private double getLinkScore(int index) {
		double score = 0;

		for (int i : page[index].child) {
			int defaultScore = page[i].defaultScore;
			int externalLinks = page[i].externalLinks;
			if (defaultScore == 0 || externalLinks == 0)
				continue;

			score += (double) defaultScore / (double) externalLinks;
		}

		return score;
	}

	private int countLink(int index, String html) {
		int i = 0;
		int count = 0;

		while (true) {
			i = html.indexOf("<a href=", i);
			if (i == -1)
				break;

			int sUrl = html.indexOf("\"", i) + 1;
			int eUrl = html.indexOf("\"", sUrl);
			String url = html.substring(sUrl, eUrl);
			if (urls.containsKey(url))
				page[urls.get(url)].child.add(index);

			i = eUrl;
			count++;
		}

		return count;
	}

	private int countWord(String word, String html) {
		char[] cHtml = html.toCharArray();

		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < cHtml.length; i++) {
			if ('a' <= cHtml[i] && cHtml[i] <= 'z') {
				sb.append(cHtml[i]);
				continue;
			}
			if (word.equals(sb.toString()))
				count++;
			sb = new StringBuilder();
		}

		return count;
	}

	private String getUrl(String html) {
		int sMeta = html.indexOf("<meta property=\"og:url\"");
		int sContent = html.indexOf("content", sMeta);
		int sUrl = html.indexOf("\"", sContent) + 1;
		int eUrl = html.indexOf("\"", sUrl);
		return html.substring(sUrl, eUrl);
	}

	private class Page {
		public int index;
		public String html;
		public int defaultScore, externalLinks;
		public double linkScore, matchingScore;
		public List<Integer> child;

		public Page(int index, String html) {
			this.index = index;
			this.html = html;
			this.child = new ArrayList<Integer>();
		}
	}
}