package com.example.demo.call;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;

public class CallHandler {

	@Autowired
	public JEReporter jeReporter = new JEReporter();

	@Autowired
	private SEReporter seReporter = new SEReporter();

	@Autowired
	private MgrReporter mgrReporter = new MgrReporter();

	Queue<Call> JEqueue = new PriorityQueue<Call>();

	Queue<Call> SEqueue = new PriorityQueue<Call>();

	@Autowired
	CallReceiver callReceiver;

	public void ProcessJeQueue(List<CallRecord> cr) {

		while (!JEqueue.isEmpty()) {
			Call c = (Call) JEqueue.poll();

			/*
			 * System.out.println("-----"); System.out.println(c.getPriority());
			 * System.out.println(c.getExecutiveno());
			 * System.out.println(c.getTimeSpent()+"----");
			 */
			// System.out.println(c.getCallReceiver());
			CallRecord callrecord = new CallRecord();
			int timeCheck = c.getCallReceiver().getMaxDuration();
			if (c.getTimeSpent() > timeCheck) {
				if (c.getCallReceiver().getEtype().toString().equals("JE")) {
					jeReporter.setEscalated(jeReporter.getEscalated() + 1);
				} else if (c.getCallReceiver().getEtype().toString().equals("SE"))
					seReporter.setEscalated(seReporter.getEscalated() + 1);
				else if (c.getCallReceiver().getEtype().toString().equals("MGR"))
					mgrReporter.setEscalated(mgrReporter.getEscalated() + 1);
				callrecord.setId(c.getExecutiveno());
				callrecord.setStatus(1);
				callrecord.setTime(c.getTimeSpent());

			} else {
				callrecord.setId(c.getExecutiveno());
				callrecord.setStatus(0);
				callrecord.setTime(c.getTimeSpent());

			}
			cr.add(callrecord);
		}
	}

	public Request getRequest() {
		List<String> jeTime = new ArrayList<>();
		jeTime.add("5,7,6,4,6");
		jeTime.add("5,8,7,5,10");
		jeTime.add("7,5,6,14,6");
		jeTime.add("10,4,9,5,12");
		jeTime.add("6,10,11,4,6");
		List<String> seTime = new ArrayList<>();
		seTime.add("6,14,12,10,5");
		seTime.add("18,8,6,4,12");
		seTime.add("8,6,13,7,1");

		Request request = new Request();
		request.setNumber_of_calls("30");
		request.setJe(jeTime);
		request.setSe(seTime);
		request.setMgr("20,12,25,83,20,3,3,3,9,2,7,1,7,11,10");
		return request;

	}

	public void addJEinQueue(Request request, int max, String Executive) {
		int jeno = 0;
		int priority = 0;
		List<String> executives = new ArrayList<>();
		EType etype = null;

		switch (Executive) {
		case "je":
			executives.addAll(request.getJe());
			etype = etype.JE;
			callReceiver = new JE(etype.JE);
			break; // optional

		case "se":
			executives.addAll(request.getSe());
			etype = etype.SE;
			callReceiver = new SE(etype.SE);
			break; // optional
		case "mgr":
			executives.add(request.getMgr());
			etype = etype.MGR;
			callReceiver = new MGR(etype.MGR);
			break; // optional

		}

		for (String s : executives) {

			String[] time = s.split(",");
			int iterationCount = max > time.length ? time.length : max;
			if (Executive.equals("mgr")) {
               System.out.println(iterationCount);
			}
			// Call c;
			for (int i = 0; i < iterationCount; i++) {
				Call c = new Call(priority++, Integer.parseInt(time[i]), Executive + jeno, callReceiver);
				JEqueue.add(c);
				// System.out.println(Integer.parseInt(time[i]));

			}
			jeno++;

		}

	}

	public void test() {

		Request request = getRequest();

		int max = Integer.parseInt(request.getNumber_of_calls()) / 8;

		addJEinQueue(request, max, "je");
		List<CallRecord> cr = new ArrayList<>();
		ProcessJeQueue(cr);
		addJEinQueue(request, max, "se");
		ProcessJeQueue(cr);
		System.out.println(seReporter.getEscalated() + "-hdhdhdh");
		addJEinQueue(request, seReporter.getEscalated(), "mgr");

		ProcessJeQueue(cr);
		for (CallRecord c : cr) {
			// System.out.println("-----");
			if (c.getStatus() == 1) {
				System.out.println(c.getId());
				System.out.println(c.getTime());
				System.out.println(c.getStatus() + "----");
			}

		}

		/*
		 * JEReporter x = new JEReporter(); x.setCallAttended(6);
		 * System.out.println(x.getCallAttended());
		 */

	}
}
