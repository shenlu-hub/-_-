# java第四次实验
计G202 申麓 2020322096
# 实验目的
1. 掌握Java中抽象类和抽象方法的定义； 
2. 掌握Java中接口的定义，熟练掌握接口的定义形式以及接口的实现方法
3. 了解异常的使用方法，并在程序中根据输入情况做异常处理
# 实验内容
某学校为了给学生提供勤工俭学机会，也减轻授课教师的部分压力，准许博士研究生参与课程的助教工作。此时，该博士研究生有双重身份：学生和助教教师。
1. 设计两个管理接口：学生管理接口和教师管理接口。学生接口必须包括缴纳学费、查学费的方法；教师接口包括发放薪水和查询薪水的方法。
2. 设计博士研究生类，实现上述的两个接口，该博士研究生应具有姓名、性别、年龄、每学期学费、每月薪水等属性。
3. 编写测试类，并实例化至少两名博士研究生，统计他们的年收入和学费。根据两者之差，算出每名博士研究生的年应纳税金额

# 实验要求
1. 在博士研究生类中实现各个接口定义的抽象方法;
2. 对年学费和年收入进行统计，用收入减去学费，求得纳税额；
3. 国家最新纳税标准（系数），属于某一时期的特定固定值，与实例化对象没有关系，考虑如何用static  final修饰定义。
4. 实例化研究生类时，可采用运行时通过main方法的参数args一次性赋值，也可采用Scanner类实现运行时交互式输入。
5. 根据输入情况，要在程序中做异常处理。
# 实验过程
- 一共定义了三个类：Graduate，StudentInterface,TeacherInterface
- 其中定义了两个接口：StudentInterface,TeacherInterface
- Graduate类调用StudentInterface,TeacherInterface这两个接口
- Graduate类中创建了两个对象，graduate1和graduate2来赋给对象姓名，年龄，性别等信息
### 学生接口类和教师接口类，下面以学生接口类为例
以下代码为设置学生的学费以及获取学生的学费，用abstract来修饰

```
    public abstract void setFee(double fee);
    public abstract void getFee(double fee);
```
教师接口类
```
    public abstract void setPay(double pay);
    public abstract void getPay(double pay);
```
### 本题采用键盘录入和get，set方法的方式来完成数据的读取和计算
此处用setPay和getPay为例
系统会提示用户输入自己一个月的工资，setPay用来设置，并乘以12来计算出一年的收入，在用户输入完之后给出计算完的结果，getPay用来获取
下列代码为键盘录入
```
Scanner scanner = new Scanner(System.in);
			System.out.println("请输入你的月工资：");
			double pay = scanner.nextDouble();
```
下列代码为setpay和getpay的方法
```
public void setPay(double pay) {
			this.pay = pay * 12;
			System.out.println("你的年收入为：" + this.pay);
		}
		
		
		@Override
		public void getPay(double pay) {
			this.pay = pay * 12;
			System.out.println("你的年收入为：" + this.pay);
		}
		
```
### 纳税判断（此处用boolean来进行判断）
用年收入减去学费，如果大于3000，则按照年收入的3%纳税，同时给出纳税金额和收入减去学费的剩余金额，在最后提醒用户可以自给自足；如果小于3000，则无需纳税，同时给出收入减去学费的剩余金额，在最后提醒用户可以申请贷款。
判断是否需要纳税
```
public boolean Loan(){
			if ((this.pay - this.fee) < 3000) {
				System.out.println("你的年收入" + this.pay + "  减去学费" + this.fee + " 等于" + (this.pay - this.fee));
				return true;
			}
			System.out.println("你的年收入" + this.pay + "   除去纳税"+this.pay*0.03+"  减去学费" + this.fee + " 等于" + (this.pay - this.fee));
			return false;
		}
```
判断是否需要贷款，用boolean来判断，一共两种情况
```
boolean flag = graduate1.Loan();
			if (flag) {
				System.out.println("贷款了解一下嘛？");
			}else {
				System.out.println("同学很棒哦，自给自足，丰衣足食！");
			}
```

### 异常处理
当用户输入的学费为0时，系统会给出提示，提示学费不能为0，但是程序继续运行
```
try {
				System.out.println("请输入你的学费：");
				double fee = scanner.nextDouble();
				graduate1.setFee(fee);
				if(fee==0) {
					System.out.println("学费不能为0哦");
				}
			}catch(Exception e) {
				
			}
```
# 运行结果
程序正常的运行结果
![运行结果](https://github.com/shenlu-hub/-_-/blob/main/%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C.PNG)

有异常处理事件的运行结果
![异常处理](https://github.com/shenlu-hub/-_-/blob/main/%E5%BC%82%E5%B8%B8%E5%A4%84%E7%90%86.PNG)

# 实验总结
- 掌握了接口的定义与实现
- 掌握了抽象类方法的定义
- 实现了键盘录入数据
- 掌握了异常处理机制的基本结构和方法
- get方法还不够完善，返回值类型还没有弄懂，我有试着改，但是程序的报错一直在兜圈子，最后也没有找到解决办法，以后封装的知识还有待进一步学习和钻研

