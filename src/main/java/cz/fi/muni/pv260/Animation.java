package cz.fi.muni.pv260;

import java.awt.Image;
import java.util.ArrayList;
public class Animation {
	
	private ArrayList scenes;
	private int sceneIndex;
	private long movieTime;
	private long totalTime;
	
	public Animation(){
		scenes = new ArrayList();
		totalTime = 0;
		start();
	}
	
// --Commented out by Inspection START (31-03-2020 15:12):
//	public synchronized void addScene(Image i, long t){
//		totalTime += t;
//		scenes.add(new oneScene(i,totalTime));
//	}
// --Commented out by Inspection STOP (31-03-2020 15:12)

	public synchronized void start(){
		movieTime = 0;
		sceneIndex = 0;
	}
	
	public synchronized void update(long timePassed){
		if(scenes.size()>1){
			movieTime += timePassed;
			if(movieTime>=totalTime){
				movieTime = 0;
				sceneIndex = 0;
			}
			while(movieTime > getScene(sceneIndex).endTime){
				sceneIndex++;
			}
		}
	}
	
	public synchronized Image getImage(){
		if(scenes.size()==0)
		{
			return null;
		}else{
			return getScene(sceneIndex).pic;
		}
	}
	
	private oneScene getScene(int x){
		return (oneScene)scenes.get(x);
	}
	
	private class oneScene{
		Image pic;
		long endTime;
		
		public oneScene(Image pic,long endTime){
			this.pic = pic;
			this.endTime = endTime;	
		}
	}
}
