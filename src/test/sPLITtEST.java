package test;

public class sPLITtEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="|十二数据培训|12数据学习|数据分析12学习|";
		String [] skillArray=string.split("\\|");
		System.out.println(skillArray.length);
		for(int i=0;i<skillArray.length;i++)
			System.out.println(skillArray[i]);
	}

}
