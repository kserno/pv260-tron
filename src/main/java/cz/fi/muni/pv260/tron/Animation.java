package main.java.cz.fi.muni.pv260.tron;


import java.awt.Image;
import java.util.ArrayList;
public class Animation {

	private ArrayList scenes;
	private int sceneIndex;
	private long movieTime;
	private long totalTime;

// --Commented out by Inspection START (23-03-2020 13:12):
//	public Animation(){
//		scenes = new ArrayList();
//		totalTime = 0;
//		start();
//	}
// --Commented out by Inspection STOP (23-03-2020 13:12)

// --Commented out by Inspection START (23-03-2020 12:58):
//	public synchronized void addScene(Image i, long t){
//		totalTime += t;
//		scenes.add(new oneScene(i,totalTime));
//	}
// --Commented out by Inspection STOP (23-03-2020 12:58)

	public synchronized void start(){
		movieTime = 0;
		sceneIndex = 0;
	}

// --Commented out by Inspection START (23-03-2020 13:12):
//	public synchronized void update(long timePassed){
//		if(scenes.size()>1){
//			movieTime += timePassed;
//			if(movieTime>=totalTime){
//				movieTime = 0;
//				sceneIndex = 0;
//			}
//			while(movieTime > getScene(sceneIndex).endTime){
//				sceneIndex++;
//			}
//		}
//	}
// --Commented out by Inspection STOP (23-03-2020 13:12)

// --Commented out by Inspection START (23-03-2020 13:12):
//	public synchronized Image getImage(){
//		if(scenes.size()==0)
//		{
//			return null;
//		}else{
//			return getScene(sceneIndex).pic;
//		}
//	}
// --Commented out by Inspection STOP (23-03-2020 13:12)

	private oneScene getScene(int x){
		return (oneScene)scenes.get(x);
	}

	private class oneScene{
		Image pic;
		long endTime;

// --Commented out by Inspection START (23-03-2020 13:12):
//		public oneScene(Image pic,long endTime){
//			this.pic = pic;
//			this.endTime = endTime;
//		}
// --Commented out by Inspection STOP (23-03-2020 13:12)
	}
}
