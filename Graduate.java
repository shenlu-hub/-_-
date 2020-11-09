/*
 * author shenlu
 * 
 */
package fourth;

import java.util.Scanner;

public class Graduate implements StudentInterface,TeacherInterface{
	// 成员变量
		String name;
		String sex;
		int age;
		double fee;
		double pay;
		
		// 实现接口中的抽象方法
		@Override
		public void setPay(double pay) {
			this.pay = pay * 12;
			System.out.println("你的年收入为：" + this.pay);
		}
		
		// 实现接口中的抽象方法
		@Override
		public void getPay(double pay) {
			this.pay = pay * 12;
			System.out.println("你的年收入为：" + this.pay);
		}
		
		// 实现接口中的抽象方法
		@Override
		public void setFee(double fee) {
			this.fee = fee;
			System.out.println("你一年的学费为：" + this.fee);
		}
		
		// 实现接口中的抽象方法
		@Override
		public void getFee(double fee) {
			this.fee = fee;
			System.out.println("你一年的学费为：" + this.fee);
		}
		
		/**
		 *  是否要贷款
		 * @return
		 */
		public boolean Loan(){
			if ((this.pay - this.fee) < 3000) {
				System.out.println("你的年收入" + this.pay + "  减去学费" + this.fee + " 等于" + (this.pay - this.fee));
				return true;
			}
			System.out.println("你的年收入" + this.pay + "   除去纳税"+this.pay*0.03+"  减去学费" + this.fee + " 等于" + (this.pay - this.fee));
			return false;
		}
		
		public static void main(String[] args) {
			// 创建一个研究生对象
			Graduate graduate1 = new Graduate();
			Graduate graduate2 = new Graduate();
			// 研究生对象的初始化
			graduate1.name = "小明同学";
			graduate1.age = 27;
			graduate1.sex = "男";
			
			graduate2.name = "小红同学";
			graduate2.age = 26;
			graduate2.sex = "女";
			
			System.out.println("你好:" + graduate1.name+"   年龄："+graduate1.age+"岁"+"    性别："+graduate1.sex);
			
			// 设置月工资
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入你的月工资：");
			
			double pay = scanner.nextDouble();
			graduate1.setPay(pay);
			
			// 设置学费
			try {
				System.out.println("请输入你一年的学费：");
				double fee = scanner.nextDouble();
				graduate1.setFee(fee);
				if(fee==0) {
					System.out.println("学费不能为0哦");
				}
			}catch(Exception e) {
				
			}
			
			
			// 判断是否需要贷款
			boolean flag = graduate1.Loan();
			if (flag) {
				System.out.println("贷款了解一下嘛？");
			}else {
				System.out.println("同学很棒哦，自给自足，丰衣足食！");
			}
			
			System.out.println();
			//第二个博士生
			System.out.println("你好:" + graduate2.name+"   年龄："+graduate2.age+"岁"+"    性别："+graduate2.sex);
			
			Scanner scanner1 = new Scanner(System.in);
			System.out.println("请输入你的月工资：");
			
			double pay1 = scanner1.nextDouble();
			graduate1.setPay(pay1);
			
			// 设置学费
			try {
				System.out.println("请输入你的学费：");
				double fee = scanner.nextDouble();
				graduate1.setFee(fee);
				if(fee==0) {
					System.out.println("学费不能为0哦");
				}
			}catch(Exception e) {
				
			}
			
			
			// 判断是否需要贷款
			boolean flag1 = graduate1.Loan();
			if (flag1) {
				System.out.println("贷款了解一下嘛？");
			}else {
				System.out.println("同学很棒哦，自给自足，丰衣足食！");
			}
		}
	 

}
