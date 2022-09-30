package coding.test.programmers.Lv3.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv3단어변환 {

	class Item{
		String word;
		int index;

		public Item(String word, int index) {
			this.word = word;
			this.index = index;
		}
	}

	public int solution(String begin, String target, String[] words) {
		if(!isExist(target,words)) return 0;

		List<String> list = new ArrayList<>();
		boolean[] visited = new boolean[words.length];
		Queue<Item> q = new LinkedList<>();
		q.offer(new Item(begin,0));

		while(!q.isEmpty()){
			final Item poll = q.poll();
			list.add(poll.word);

			if(poll.word.equals(target)) {
				return poll.index;
			};

			for (int i = 0; i < words.length; i++) {

				if(!visited[i] && isDifferentOnlyOne(words[i], poll.word)){
					visited[i] = true;
					q.offer(new Item(words[i], poll.index+1));
				}

			}

		}

		return 0;
	}

	private boolean isDifferentOnlyOne(String word, String poll) {
		int difference = 0;
		final char[] wordArr = word.toCharArray();
		final char[] pollArr = poll.toCharArray();
		for (int i = 0; i < poll.length(); i++) {
			if(wordArr[i] != pollArr[i]) difference++;
		}

		return  difference == 1;
	}

	private boolean isExist(String target, String[] words) {
		for (int i = 0; i < words.length; i++) {
			if(words[i].equals(target)) return true;
		}
		return false;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}),4);
		Assertions.assertEquals(solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log"}),0);
	}

}
