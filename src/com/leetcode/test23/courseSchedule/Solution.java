package com.leetcode.test23.courseSchedule;

import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] c = {{5,5},{4,6},{2,6}};
		//int[][] c = {{100,200},{200,1300},{1000,1250},{2000,3200}};
		System.out.println(s.scheduleCourse(c));
	}
	
	public int scheduleCourse(int[][] courses) {
		PriorityQueue<Course> q = new PriorityQueue<>((c1, c2) -> c2.days - c1.days);

		PriorityQueue<Course> sortedByDuration = new PriorityQueue<Course>((c1, c2) -> c1.duration - c2.duration);

		for (int i = 0; i < courses.length; i++) {
			if (courses[i][0] <= courses[i][1])
				sortedByDuration.add(new Course(courses[i][0], courses[i][1]));
		}

		int totalDays = 0;
		while(!sortedByDuration.isEmpty()) {
			Course c = sortedByDuration.poll();
			if(c.days + totalDays <= c.duration) {
				q.add(c);
				totalDays += c.days;
			} else {
				Course toRemove = q.peek();
				if(c.days + totalDays - toRemove.days <= c.duration) {
					q.poll();
					totalDays = totalDays - toRemove.days + c.days;
					q.add(c);
				}
			}
		}
		return q.size();
	}

	class Course {
		
		int days;
		int duration;
		
		Course(int d, int dur) {
			duration = dur;
			days = d;
		}
	}
}
