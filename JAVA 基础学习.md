# JAVA 基础学习

[【零基础 快速学Java】韩顺平 零基础30天学会Java_哔哩哔哩 (゜-゜)つロ 干杯~-bilibili](https://www.bilibili.com/video/BV1fh411y7R8?p=20&spm_id_from=pageDriver)

## 少截图，多总结

## 安装问题

* 汉化

  * 1. 安装package control

    ```
    import urllib2,os;pf='Package Control.sublime-package';ipp=sublime.installed_packages_path();os.makedirs(ipp) if not os.path.exists(ipp) else None;open(os.path.join(ipp,pf),'wb').write(urllib2.urlopen('http://sublime.wbond.net/'+pf.replace(' ','%20')).read())
    ```

## 记得上传图床

## day1 P1-19

* JAVA核心机制**：（JVM  *java虚拟机*，包含在JDK  *JAVA开发工具包*中）**

JDK = JRE（*JAVA运行环境*）+JAVA的开发工具（*javac*，编译；java，运行），JRE = JVM+JAVA的核心类库

一个类对应一个class

*  文件中只能有一个public，且文件名只能以public class命名。

## day2  P20-70

* 文档注释**（我这边javadoc不能用）**

```
/**
*
*
*/

javadoc -d 文件名 -xx -yy 名字.java
```

类和方法要以文档注释javadoc方式来写

给代码维护者看的注释，用单行注释，多行注释。

* 源文件必须使用utf-8
* /t，转义符；/n，换行符
* 变量。先声明后赋值；申明long类型后面必须加L，l；
* 浮点数  = 符号位 +指数位+尾数位
* 浮点型默认位fdouble个字节，申明float，后面要加F,f。 
* 浮点使用陷阱 0.27与0.81/3比较。
* 中文在线文档网站,matools
* ctrl+shift+D，粘贴光标的所在行。 
* 单个字符必须是单引号，字符串用双引号
* 字符本质，a--->码值97--->二进制
* 自动类型转换
  * ![image-20210515182308267](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210515182308267.png) 
  * 有多种类型在一起 混合运算时，系统自动将所有数据转换成容量最大的那种数据，再进行计算。
* byte，short，char 他们三者计算时，首先要转换为int
* 字符串。String s1 =  n1+“ ”
  * string 字符串转其他。Float.parseFloat()等，转化为char，类似切片s.charAt(n)
* a%b = a  -  a/b*b
* 前++：先自增再赋值；后++：先赋值再自增。
* &&和&的区别：&&短路与，如果第一个条件为False，第二个不会判断，效率高。同理 ||和|。
* a^b，异或，不同，结果为True
* 三元运算符；条件表达式？表达式1：表达式2
* 标识符规范：包名,aaa.bbb.ccc;类名：xxxYyyZzz（小驼峰，驼峰法）；常量名：XXX_YYY_ZZZ
* 进制介绍
  * 二进制0b，0B
  * 十进制，0-9
  * 八进制，以数字0开头
  * 十六进制，0X，0x开头
* 源码、补码、补码
  * 二进制最高位为符号位，0为正数，1为负数。
  * 正数的三码合一
  * 负数的反码，符号位不变，其他位取反
  * 负数的补码 = 反码+1，负数的反码 = 补码 - 1
  * 0的反码，补码还是0
  * java都有符号
  * 计算机都是以补码的方式计算
  * 看运算结果要看她的原码

## day3 P104-136

* switch的注意事项：
  * case的数据类型要和条件类型一致
  * char 和 int 可以转换 ，不会出现错误
* switch（表达式）中的返回值必须为（byte,shaor,int,har,enum[枚举]，String）
* case后面的值不能是变量
* 如果没有break，那么就会全部执行到结尾
* 核心思想：**化繁为简、先死后活**

## Day4 P137-158

* break
  * break+标签，跳出该标签的循环，如果不写标签，自动跳出内循环。
* 字符串的比较用xxx.equals("")
* return
  * 当return用在方法时，表示跳出方法；如果用在main中，表示退出函数。

## Day5 P159-171

* 数组

  * 静态数组 

    ```
    int A[] = {a,b,c}
    ```

  * 动态数组

    ```
    int[] A = new int[] || int A[] = new int[]
    ```

  * 数组赋值赋的是地址，赋值方式为引用赋值。

  * ![image-20210618220023310](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210624181225126.png)

  * 数组的copy
    
    * 新建动态数组，占据堆。

## Day6 P172-187

* 冒泡算法
  * n个元素
  
  * 进行n-1次排序
  
  * 两个指针在每次排序中循环，每次确定一个最大的数。
  
  * ==需要注意的是，“\t”和‘\t’是不同的结果==
  
  * ```
    class ArrayMaoPao {
        public void way(int a[]) {
            int temp = 0;
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = 0; j < a.length - i - 1; j++) {
                    if (a[j]>a[j+1]){
                        temp = a[j];
                        a[j] = a[j+1];
                        a[j+1] = temp;
                    }
                }
            }
        }
    }
    ```
  
* 查找算法

  * 使用index在for循环外添加一个flag，如果没有找到，则不变。

* 二维数组

  * ==先在栈指向堆的行的位置，然后在堆里指向堆的行的内容==

  ![image-20210624181122627](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210624181122627.png)

  * 因此定义二维数组时，一定要给一维数组开空间。

* 杨辉三角

  * ```java
    //核心代码 a[i][j] = a[i-1][j-1]+a[i-1][j]
    
    public class cainiao{
    	public static void main(String[] args) {
    		int a[][] = new int[10][];
    		for(int i = 0 ; i < 10 ; i++){
    			a[i] = new int[i+1];
    			for (int j = 0; j<a[i].length; j++){
    
    				if( j == 0 || j == a[i].length - 1){
    					a[i][j] = 1 ;
    				}else{
    				a[i][j] = a[i-1][j]+a[i-1][j-1];
    				}
    			}
    		}
    		for(int i = 0 ; i < a.length ; i++){
    			for (int j = 0 ; j < a[i].length ; j++){
    				System.out.print(a[i][j] + "\t");
    				
    			}
    			System.out.println();
    		}
    	}
    }
    ```


## Day7 P188-200

* 类与对象
  * 类是定义数据类型，包含一些属性

  * 对象是类的实例化

  * java最大的特点就是面向对象

  * 对象内存布局
    * ![image-20210624181225126](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210618220023310.png)
    * 其中，基本数据类型存放在堆中，引用数据类型例如字符型数据放在方法区中，在不同版本又叫做**元空间**
    
  * 创建对象的流程

    * ```java
      Person p = new 	Person();
      p.name = "小猪"
      ```

    * 具体流程
    
      * 先加载Person类信息（属性和方法信息，只加载一遍）
      * 在堆中分配空间，进行默认初始化（看规则）
      * 把地址赋给P，P指向对象
      * 进行指定初始化

## Day8 P201-210
* 方法调用机制
  * ![image-20210626154308573](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210626154308573.png)
* 方法使用细节
  * 一个方法最多只能有一个返回值，多个返回值可以用数组方式返回。
  * void单纯只加一个return
  * 方法不能嵌套
  * 同一类的方法直接调用，跨类的方法需要通过对象名调用
  * 使用Scanner时当为char时：char key = myScanner.next().charAt(0);

## Day9 P211-217

- 成员传参机制1（**非常重要**）

  - **B类的实参传入A类的形参，进行一系列方法调用，但是B类的实参参数不会变化。**
  - **调用方法就会在栈里开辟一个新的栈**，栈内运行完毕会自动销毁。

  ![image-20210627183735573](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210627183735573.png)

* 成员传参机制2（**非常重要**）
  * 数组类型属于引用类型，创建在堆里，**拷贝的是地址。**
  * 调用方法就会在栈里开辟一个新的栈，此时形参可以影响实参。
  * **对象传递也是引用传递**
  * ![image-20210627192014396](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210627192014396.png)

* 成员传参机制3（**非常重要**）
  * 新建同一个名字的对象会新建另一个不同的堆空间
  * 不同类引用的地址是不同的对象地址
  * 创建不用的对象会被作为“垃圾对象”处理掉
  * ![image-20210627194801244](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210627194801244.png)

* 对象克隆

  * ```java
    public class cainiao{
    	public static void main(String[] args) {
    	pig p = new pig();
    	p.age = 10;
    	p.name = "ss";
    	Copy mycopy = new Copy();
    	pig p2 = mycopy.copypig(p);
    	System.out.println("p2.age="+p2.age+"\t"+"p2.name=" + p2.name);
    	}
    }
    class pig{
    	int age;
    	String name;
    }
    class Copy{
    	public pig copypig(pig p){
    		pig p2 = new pig();
    		p2.age = p.age;
    		p2.name = p.name;
    		return p2;
    	} 
    }
    ```
## Day10 P218-227
* 递归

  * 栈是先进后出的。
  * 每一个栈都有自己的栈内的基本数据值。
  * ![image-20210627211842606](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210627211842606.png)

* 递归的重要规则

  * 执行一个方法，就开辟一个新的栈空间。
  * 方法的变量是局部的，不会相互影响
  * 方法使用是**引用变量**的话，会共享引用类型的数据。
  * **递归必须向退出递归的条件逼近，不然就死循环了**

* 老鼠迷宫问题（很难需要好好看）

  * ![image-20210628153912566](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210628153912566.png)

    

  * 上下左右的路径的策略不同，结果就不同

  * 同时满足回溯现象\\\退到上一个栈

  * ```java
    //0可以走的路，1表示障碍物，2表示可以走的方向，3表示走过但走不通。
    class T {
    	public boolean findWay(int map[][],int x , int y){
    		if (map[6][5] ==2){
    			return true;
    		}else{
    			if(map[x][y] ==0){
    				map[x][y] = 2; //假设可以走得通
    				if(findWay(map,x+1,y)){
    					return true;
    				}else if (findWay(map,x,y+1)) {
    					return true;
    				}else if (findWay(map,x-1,y)){
    					return true;
    				}else if (findWay(map,x,y-1)) {
    					return true;
    				}else
    				{
    					map[x][y] = 3 ;	
    					return false;
    				}
    			}else{
    				return false ;
    			}
    		}
    	}
    }
    ```
## Day11 P227-228
  * 汉诺塔递归问题

    ```java
    class tower{
    	public void move(int num , char a ,char b ,char c){
    		if(num==1){
    			System.out.println( a + "--->" + c);
    		}else{
    			move(num - 1 , a , c , b ) ;  
    			System.out.println( a + "--->" + c);
    			move(num - 1 , b , a , c);
    		}
    	}
    }
    ```
    
  * 八皇后问题

## Day12 P229-243

* 重载
  * 方法名可以一致，但形参不一致。。
  * 自动匹配形参和实参 数量与类型一致。
  * 如果匹配两个或以上 参数一致，erro。
* 可变参数
  * 可变参数的实参可以是数组。
  * 可变参数的本质就是数组。
  * 可变参数可以和普通类型的参数一起，可变参数要放在最后。
  * 一个形参列表中只能有一个可变参数。
* 属性和局部变量
  * 类下方法外是属性，不赋值默认为零
  * 方法内是局部变量
  * 可以重名，访问时就近原则
  * 属性或全局变量可以被其他类调用，局部变量只能在该类下使用
  * 全局/属性可以加修饰符，局部不可以
* 构造器
  * 完成对象的初始化。
  
  * 方法名与类名相同，且米有返回值
  
  * 创建对象时，会自动调用，完成对象的属性初始化。
  
  * 一个类可以定义多个构造器，构成==方法重载==。
  
  * 有默认构造器，可以用javap查看。
## Day13 P244-260

* 对象创建流程
  * ![image-20210701100335775](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210701100335775.png)
  * ==对象创建在堆里，对象引用在栈里==。
  * 方法加载在方法区
  * 具体流程
    * 加载person类信息
    * 在堆中分配空间（地址）
    * **首先**完成对象初始化 【age = 0，name = null】，**然后**进行显式初始化，**最后**是构造器初始化。
    * 把对象在堆里的地址返回给p（p是对象名，也可以理解为度对象的引用，在栈里）
  
* this

  * ![image-20210701122127452](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210701122127452.png)

  * 一个对象默认生成一个this地址

  * 在构造器中使用this，可以避免属性名和局部变量相同的问题。

  * ```java
    //this
    public class cainiao{
    	public static void main(String[] args) {
    		dog dog1 = new dog("jack",18);
    		dog1.init();
    	}		
    }
    
    class dog{
    	String name;
    	int age;
    	public dog(String name ,int age){
    		this.name = name;  //这里的this表示是对象属性的name，后面的name就是局部变量的name
    		this.age = age;	   //如果不加的话，就是局部变量赋值给自己，而属性没有变，init语句输出的就是0.
    	}
    	public void init(){
    		System.out.println(name+"  "+ age);
    	}
    }
    ```

* ==匿名对象只能用一次（new dog().name()），运行完就销毁了。==

* 一个新对象会重新在堆里开辟新的空间

* 使用在复用构造器中使用this（），只能在第一行使用。

## Day14 P261-262

* 数组的引用不需要[]。
* ==P262作业残留问题，看到以后注意解决。==

## Day15 P263-284

* 模版/自定义模版
  * file->setting->editor->live template
* package +包名 自定义包
* 访问修饰符
  * ![image-20210705161054948](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210705161054948.png)

* 只有默认和public可以修饰类
* 面对对象编程---封装
  * 属性私有化
  * 提供public  set方法
  * 提供public get方法，获取属性的值

## Day16 P285-305

* 引出继承的必要性**（extends）**
  * 类与类之间的属性和方法相同太多
  * 提高代码的复用性
  * 代码的扩展性和维护性提高了
* 继承的细节
  * 子类继承了父类所有的属性和方法，但是不代表你可以用
  * 不能直接访问父类的private属性，但是可以通过public方法去访问私有的属性
  * 子类必须调用父类的构造器，完成父类的初始化。
  * 无论使用哪个子类的构造器，一定会调用父类的**无参构造器**；如果没有提供无参构造器，必须在子类的构造器中使用**super**去指定使用父类的哪个构造器完成初始化工作。而此时先运行super的构造器，其余的参数由其他参数构造器使用。
  * this（）和super （）只能在构造器中使用，都必须在最前面，不能同时用
  * ctrl+h可以看到类的继承。
* 继承的本质
  * 各类的相同属性名，调用从最底层开始调用。
  * ![image-20210706113305428](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210706113305428.png)
  * ![image-20210706131755796](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210706131755796.png)

* 为什么用super？
  * 分工明确，父类由父类初始化，子类的属性由子类初始化。
  * 当子类和父类名字重合时，必须用super。
* super注意细节
  * super调用的是父类，this调用的是自己。
  * super可以调用属性和方法，但不能调用private的属性和方法。
  * super.属性和super.方法任何位置都可以，super()只能用在构造器的第一句。
* ![image-20210706212858836](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210706212858836.png)

* 方法重写
  * ![image-20210706214751073](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210706214751073.png)

## Day17 P306-317

* 多态
  * 代买复用性不高，不利于代码的维护
  * 方法和对象具有多种形态，是面向对象的第三大特征，建立在封装和继承基础之上的。
  * 方法重载和重写体现多态
  * ![image-20210707105340021](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210707105340021.png)

* 多态的细节

  * 向上转型

    * ```
      Animal animal = new cat()
      ```

    * ![image-20210707112920900](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210707112920900.png)

    * 解释上面的，**左边的是靠javac编译，如果没有存在子类的方法就直接报错；右边是靠java运行**

    * 运行规则和this一致

    * 运行时方法在栈中开辟空间，方法执行完毕，栈释放，但信息仍在方法区。

  * 向下转型

    * ```
      Animal animal = new cat()
      Cat cat = (Cat) animal
      ```

    * ![i](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210707134926511.png)

    * 属性的值看编译类型，没有重写之说。

    * instanceOf比较操作符，用于判断对象的运行类型是否为xx类型或xx类型的子类型

    * ![image-20210707142433133](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210707142433133.png)

  * 动态绑定机制

    * 涉及到属性，属性在哪就用哪个，涉及到方法，就从对象的运行类型看起。

  * 多态的应用

    * 多态数组
    * 多态参数，**方法定义的形参为父类类型，实参可以为子类类型。**

## Day18 P318-324

* equal与“==”
  * == 比较运算符
    * 可判断基本类型，也可以判断引用类型
    * 基本类型判断值，引用类型判断地址是否相等0
  * equal方法
    * obeject的方法，只能判断地址是否相同，其中object中的equal方法是检测是否输入的为自己。
    * integer,String等都重写了obeject中的equal方法。

## Day19 P325-334

* hashcode(**十进制的hash值**)
  * ![image-20210711155105848](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210711155105848.png)
* toString(alt+insert)（**十六进制的hash值**）
  * ![image-20210711160818873](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210711160818873.png)

* finalize
  * ![image-20210711162707577](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210711162707577.png)
* 断点调试
  * ==F7跳入方法内，F8逐行执行，shift+F8跳出方法，F9resume，执行到下一个断点。==

## Day20 P335-342

零钱通项目代码完成，需要注意事项：

* 验证条件，使用==条件错误==进行优化，此时不需要else
* 用方法时，终止方法内容用return。

## Day21 P343-361

本章作业：

* |  修饰符   | 同类 | 同包 | 子类不同包 | 不同包 |
  | :-------: | :--: | :--: | :--------: | :----: |
  |  public   |      |      |            |        |
  | protected |      |      |            |   ✖    |
  |   默认    |      |      |     ✖      |   ✖    |
  | privated  |      |  ✖   |     ✖      |   ✖    |

* ```java
  public class Test06 {
      public static void main(String[] args) {
          C c = new C();// 1. 转到c无参构造器
      }
  }
  class A{ //超类
      public A(){
          System.out.println("我是A类");
      } // 5. 最后一步。
  }
  class B extends A{
      public B(){
          System.out.println("我是b类的无参构造");
      }
      public B(String name){
          //super()  
          System.out.println(name+"我是b类的有参构造");
          // 4.构造器默认继承上级的无参构造器， 转到a无参。
      }
  }
  class C extends B{
      public C(){
          this("hello");//2. 转到c有参构造
          System.out.println("我是c类无参构造器");
      }
      public C(String name){
          super("haha"); //3. 转到b有参
          System.out.println("我是c类有参构造");
      }
  }
  ```

## Day22 P362-373

![image-20210720165451485](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210720165451485.png)

## Day23 P374-393

* 静态变量

  * 当所有对象都需要共享一个变量时用静态变量
  * 被同一类的所有对象共享
  * 不创建对象也可以直接通过类访问，而非静态不行
  * 类加载就会生成静态域

* 静态方法

  * 访问静态变量
  * 经典使用场景
    * 不需要创建对象，直接可以调用方法。
  * 静态方法无this和super的参数
  * 静态方法只能访问静态成员
  * 普通方法可以访问静态和非静态成员

* 理解main方法

  * ```
    public static void main(String[] arg){}
    ```

  * main方法是java虚拟机在调用，因为它不属于任何一类，所以他用public

  * 用静态方法可以不创建对象

  * ![image-20210721120257608](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210721120257608.png)

  * ![image-20210721120652433](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210721120652433.png)

* 代码块
  * 分类
    * 静态 ==随着类的加载而执行，只会执行一次（调用多次成员方法的时候，只会加载一次类）==
      * 创建对象实例（new）
      * 创建子类对象实例，父类也会加载 ，**加载子类前，一定会先加载父类。**
      * 使用类的静态成员时
    * 非静态/普通 ==没创建一个对象就执行一次==
      * 和类加载没什么关系
    
  * 静态代码块只能调动静态成员，普通代码块都可以调用
  
  * 相当于构造器的补充机制，提高代码的复用性
  
  * 代码块优先于构造器被调用！
  
  * 静态属性和静态代码块拥有同等的优先级
  
  * 普通代码块和普通属性的初始化拥有同等的优先级
  
  * 在继承关系中
  
    * ```
      public b{
      super{}
      //本类代码块
      sout // 本类构造器调用
      }
      ```
  
  * 构造顺序
  
    * ![image-20210721144628051](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210721144628051.png)

* 单例设计模式

  * 采取一定的方法，保证在整个软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得对象实例的方法。

  * 分类：饿汉式（只要类加载，无论你用不用，他都会产生对象）

    * 无线程问题

    * ```
      //将构造器私有化
      //在类的内部直接创建 私有静态对象
      //提供一个公共的static方法，返回对象
      ```

  * 分类：懒汉式（把创建对象放在方法里）

    * 只有当用户使用该方法时才会生成对象
    * 有线程安全问题

## Day24 P394-416

* final

  * 需求：
    * 不被类继承
    * 不希望方法被子类覆盖
    * 不希望某个属性值被修改，被称为常量，XXX_XXX
    * 不希望局部变量被修改
  * 注意：
    * 赋值位置
      * 定义
      * 构造器（静态修饰，不可以）
      * 代码块
    * 不可以继承，但可以实例化
    * 方法不可以重写，但可以继承
    * 不可以修饰构造器
    * 和static搭配效率更高（不会导致类加载，同时可以调用）

* 抽象类abstract（本质是为了强制重写父类方法）:

  * 抽象方法类中不确定的方法，但是一定存在的，比animal的eat()
  * 没有方法体
  * 不能实例化
  * 抽象类不一定必须有抽象方法，抽象方法一定是抽象类
  * 只能修饰类和方法
  * ==一个类如果继承了抽象类，那么一定要实现抽象类的所有方法。除非他自己也声明为abstract类。==
  * 不能和private、final、static修饰，和重写相违背。
  * **最佳实践—模版设计模式**，将共同部分抽象到父类模版中，将必须要但都不同的方法抽象到父类中的抽象方法中，强制重写。
  * 此方法动态绑定，跟随对象

* 接口——**升级版抽象类** 

  * 语法

    * ```
      interface 接口名｛
      	//属性
      	//方法  不需要写pubic abstract 默认。
      ｝
      class 类名 implements 接口｛
      	自己属性
      	自己方法
      	必须实现的接口的抽象方法
      ｝
      //jdk8接口可以有静态方法，以及默认方法 default
      ```

    * 一个类可以实现多个接口
    
    * 接口的属性默认为public stastic final
    
    * 接口不能继承其他类，可以继承其他接口
    
  * 类的五大成员
  
    * 属性
    * 方法
    * 构造器
    * 代码块
    * 内部类
      * 可以直接方位私有属性，体现类与类的包含关系
  
  * 内部类
  
    * 定义在外部类的局部位置上（一般在方法内，也可代码块）
      * 局部内部类（有类名）
        * 可以直接访问外部所有成员，包含私有的
        * 不能添加访问修饰符，可以用final
        * 直接访问外部成员
        * 外部访问内部：创建对象，在访问
        * 与外部重名的话，使用类型.this.属性 （本质是对象调用）
      * 匿名内部类（没有类名，重点！！！）
        * 既有定义类的特征，又有新建对象的特征
        * ==Day25==
    * 定义在外部类的成员位置上
      * 成员内部类（没有static）
        * ==Day26==
      * 静态内部类（有static）
        * ==Day26==

## Day25 P417-418

* 匿名内部类

  * 两种调用方式

    * ```
      //第一种
      Person p = new Person(){
      @Override
      }
      p.hi()
      //第二种  直接调用
      new Person(){
      @Override
      }.hi()
      ```

  * 可以直接访问外部所有成员，包含私有的

  * 运行内存 是变化的
  
  * 与外部重名的话，使用类型.this.属性 （本质是对象调用）

## Day26 P419- 443

* 成员内部类

  * 可以任意修饰符修饰，因为他本质就是成员

  * 作用域在类体中

  * 直接访问外部成员

  * 外部类访问内部，先创对象再访问

  * 调用的两种方法

    * ```
      //第一种,我这里报错
      Outer.Inner inner = Outer.new Inner()
      //第二种，创建方法返回
      outer.inner1 inner = new outer().getInner();
      inner.say()
      ```

  * 与外部重名的话，使用类型.this.属性 （本质是对象调用）

* 静态内部类

  * 只能访问静态属性
  * 作用域整个类体

* 访问

  * 直接访问外部所有静态成员

  * 外部访问内部类 **创建对象，再访问 **

  * 外部其他类访问

    * ```
      //方式一：静态可以直接访问
      Outer.Inner inner = new Outer.Inner()
      //方式二：编写一个方法。返回静态内部类的对象
      //1.编写成员方法
      //2.编写静态方法，不用new
      Outer.Inner inner = Outer.getInner()
      ```

    * 与外部重名的话，使用类型.属性 （本质static的属性调用，直接类名.属性）

* 自定义枚举类
  * 构造器私有化
  * 本类内部创建一组对象
  * 对外暴露对象（用public final static 修饰）
  * 提供get，不提供set
  * 枚举对象名通常全部大写，常量的命名规范。
* 关键词枚举类
  * 使用enum代替class
  * 定义常量对象格式  常量名（实参列表）
  * 多个对象用  ，  号隔开
  * 定义对象放在第一行
  * 如果使用无参，则可以省略（）
  * tosring返回的是对象名。**因为本类无tostring，所以查找隐式继承父类enum的tostring方法，他return的是对象的name。**
* 隐藏继承的enum的常用方法
  
  * ![image-20210726155223757](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210726155223757.png)
* 枚举可以继承接口，不能继承接口

* tips

  * ```
    //增强for循环
    int[] num = {1,2,3}
    for(int i:num){
    sout(i)
    }
    ```

* 注解 @interface修饰，意为注解类

  * **@Override重写**，只能用在方法上，**检测是否重写了**
  * **@Deprecated** 表示该元素已经过时了，但是仍然可以用，可以做版本升级过渡用
  * **@SuppressWarning抑制警告**，当你不想看到警告的时候。
    * 在｛‘’ ‘’｝写入不想显示的警告类型

* 元注解 **修饰注解的注解**

  * Retention  指定注解的作用范围，三种source、class，runtime
  * Target  指定注解哪些地方使用
  * Documented  指定注解是否会在javadoc中体现
  * Inherited  子类会继承父类注解

* static修改属性就不会变了。

## Day27-29 P444-473

* **Exception**—try-catch 

  * 组合

    * try{}catch(Exception  e){}  finnally{不管是否有异常，都会执行}
    * try-finally 不会报出异常，finally结束直接崩

  * e.getMessage

  * ctrl+alt+t

  * 运行异常（可以不作处理,默认throws处理）和编译异常（必须处理的异常）

  * 异常体系图

    * ![image-20210728095941924](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210728095941924.png)

  * 常见的运行异常举例

    * NullPointException 空指针异常 （当使用对象为null时）
    * ArithmeticException 数学运算异常
    * ArrayIndexOutOfBoundsException  数组下标越界异常
    * ClassCastException 类型转换异常 
    * NumberFormatException 数字格式不正确异常 （不能转换为适当格式）

  * 常见的编译异常举例

    * ![image-20210728103303905](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210728103303905.png)

  * try-catch 最佳实例

    * ```java
      public class Exception01 {
          public static void main(String[] args) {
              int num;
              Scanner scanner = new Scanner(System.in);
              while (true){
                  System.out.println("请输入一组数字：");
                  String  inputNum = scanner.next();
                  try {
                      num = Integer.parseInt(inputNum);
                      break;
                  } catch (NumberFormatException e) {
                      System.out.println("你是猪吗？这输入的是个数字？");
                  }
              }
              System.out.println("你输入的数字是"+num);
          }
      }
      ```

* Excepthon —throws

  * 子类抛出的异常要么为父类的异常的子类，要么是一致的。
  * ![image-20210728151208144](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210728151208144.png)

* 八大wrap类

  * ![image-20210728164611010](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210728164611010.png)

  * bool和char

    * ![image-20210728164745825](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210728164745825.png)

  * 经典面试题

    * ```
      Objecr obj1 = true?new Integer(1):new Float(2.0);
      sout(obj1);  //1.0
      //三元运算符要看成一个整体，这样就会提高整体的精度。
      ```

    * ```
      Integer i = new Integer(1);  // 新建对象
      Integer i = 1;  // 底层是Integer.valueOf(1)
      int i = 1;
      //-128  --  127 不用新建，不在这个范围需要新建对象
      //只要有基本类型，判断的就是值是否相等
      ```

* String

  * ![image-20210728193804788](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210728193804788.png)
  
  * 有很多的构造器
    * ![image-20210728193844582](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210728193844582.png)
    * 有属性private final char value[];用于存放字符内容。需要注意的是：**value是一个final类型，不可以修改地址（需要功力），但是可以修改内容**
    
  * ```
    String a = "zhu";
    String b = new String("zhu");
    sout(a==b);	F
    sout(a.equals(b));	T	
    sout(a==b.intern())	T
    sout(b==b.intern())	F	//最终返回常量池的对象地址。
    ```
  
  * ```
    String s1 = "hello";
    s1 = "hh";
    //创建两个对象
    //String是final类，一个字符串对象一旦分配不可变，修改字符串就要分配到一个新的空间
    ```
    
  * ```
    String a = "aa"+"bb";
    //创建一个对象
    //系统自动优化为 “aabb”
    ```
  
  * ```
    String a = "aa";
    String b = "bb";
    String c = a + b ;
    // 创建3个对象，第三个对象在堆里，指向常量池。
    ```
  
    * ![image-20210730133532381](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210730133532381.png)
  
  * String 常用方法
  
    * 
  
      ```
      String.equals()
      equalsIgnoreCase
      length
      indexOf
      lastIndexOf
      substring
      trim //去前后空格
      charAt
      toUpperCase() //转大写
      toLowerCase()
      concat 
      repalce
      split
      compareTo   //一样长度，做减法；不一样长度，长度做减法
      toCharArray // 转换成数组
      format()  //%s 字符串  %d 整数  %.2f 小数点，四舍五入  //%c char  
      ```
  
## Day30 P474- 485

* StringBuffer
  * 可变字符序列，是一个容器
  * 很多和String方法一样，但是他可变长度
  * 在父类中有属性Char value[]，但不是final类型，引用在堆中。
  * 里面的值可以更新内容，不用更新地址。

* StringBuffer 与String 互换

  * new StringBuffer(str) or stringBuffer.apend(str)
  * stringBuffer.toString

* StringBuffer方法

  * append
  * delete
  * replace
  * indexOf
  * insert插入  **学会从右往左插，从左往右插很难控制index**

* StringBuffer 练习

  * ```
    String str = null;
    StringBuffer sb = new StringBuffer();
    sb.append(str);
    out(sb.length())  //4 底层输出的是“null”
    
    StringBuffer sb1 = new StringBuffer(str);
    //会抛出空指针异常
    ```

* StringBuilter

  * 特点： 单线程，更快更安全，方法和String一样

* String/StringBuffer/StringBuilder

  * 后两者都是可变序列，方法也一样
  * 第一种：不可变序列，效率低，但是复用率高。
  * 第二种：可变字符序列，效率较高（增删）、线程安全
  * 第三种：可变序列、效率最高、线程不安全
  * **如果要大量修改字符串，不要用String。**

* Math

  * 常用方法
    * abs绝对值
    * pow 幂
    * ceil 向上取整
    * floor 向下取整
    * round 四舍五入
    * sqrt  求开方
    * random 求随机数（前闭后开）
    * max
    * min

* Arrays

  * 常用方法

    * toString

    * sort  因为是数组引用类型，所以会影响到之前的对象。

      * ```
        //接口编程，动态绑定，内部匿名类
        Arrays.sort(arr,new Comparator(){
        @override
        public int compare(Object o1, Object o2){
        Integer i1 = (Integer) O1;
        Integer i2 = (Integer) O2;
        return i1 - i2;
        }
        })
        ```

      * binarySearch(arr,index)  //二叉查找，数组必须是有序的

      * copyOf(arr,arr.length()) 数组复制

      * fill(num,99)  //将原来的元素全部替换为99

      * equals 

      * asList  // 转换成集合，属于Arrays的内部类ArraysList

## Day31 P486-498

* System
  * System.exit(0)   // 退出程序
  * arraycopy(src,0,dest,0,3) //原始数组  原始位置索引，目标数组，目标位置索引，长度。一般用于原码中。
  * gc()   // 垃圾回收机制
* BigInteger  // long也存不进去
  * new BigInteger(“字符串”)
  * 加减乘除都用他自己的方法
* BigDecimal  //大的浮点数
  * 除法除不尽的情况：括号里加 BigDecimal.ROUND_CEILING
* 时间类
  * Date()
  * SimpleDateFormat(“yyyy年MM月dd日 hh:mm:ss E”)
  * Calendar 日历   //没有格式方法，需要自己组合显示
  * LocalDateTime    —   JDK8
  * LocalDateTime.now()
    * LocalDate/Localtime/  .now
    * 用DateTimeFormatter.ofPattern(“yyyy年MM月dd日 hh:mm:ss E”) 格式化

## Day32 P489-529

* 集合  collection和map
  * 数组的缺点
    * 长度固定
    * 内容同一类型
    * 增删不方便
  * 集合的优点
    * 动态保存任意多个对象
    * 方便修改
  * collection集合   —  单列集合
    * ![image-20210805112717189](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210805112717189.png)
    * Collection接口无法实例化，通过继承他的子类List，Set实例化
    * List.add(对象)、remove()、contains()、size()、isEmpty()、clear()、addAll(位置，添加对象)、containsAll(查询对象)、removeAll(删除对象)、indexOf（）、lastIndexOf（）、set(index,变更名字)、subList（start,end）返回子集合、get()、size()
    * 所有的collection都继承了一个iterator接口，所以可以通过Iterator iterator = col.iterator();
    * itit快捷键直接遍历：先通过hasNext（）判断是不是指针移到最后了，然后使用next()下移指针并返回。
    * 也可使用增加for**，for（Obeject book:col）**，底层也是用的迭代器。==快捷键是大写的i==
    * 显示所有快捷键的快捷键  **ctrl + j**

* ArrayList
    * 可以加null
    * 由数组实现存储
    * 不适合多线程，可考虑**Vector**
    * 有参：第一次扩容就是1.5倍。
    * 无参：先空，进来就成10，过了10就1.5倍的加
  * Vector
  
    * 扩容机制：无参，默认10，满后，2倍；指定大小，扩两倍
  * LinkedList   单线程
  
    * 底层维护双向列表
  
    * 维护两个属性  first 和 last
  
    * 节点Node 对象维护prev、next、item三个属性
  
    * 删除和添加不是通过数组完成的，相对效率较高。
  * ArrayList/LinkedList
  * 改查多用前，增删多用后
    * 实际项目中 用 前比较多
  
* Set接口

  * 特点

    * 无序但是是固定的，没有索引
    * 不能存放重复元素，可以存放null

  * HashSet

    * 底层是HashMap，hashmap的底层是（数组➕链表+红黑树）

    * ```
      //经典面试题，能加进去吗？
      set.add(new String("zh"));
      set.add(new String("zh"));
      ```

    * 第一次添加，扩容16，临界值16*加载因子0.75 = 12 ，第二次扩容16*\*2临界值32-0375 = 24

    * 同一链条元素个数为8，假如没有table没有64，将table容量为64，进化为红黑树。

    * 注意：**只要扩增元素，哪怕是同一链条的，也算size。**
    
  * LinkHashSet

    * HashSet的子类，底层LinkHashMap，底层维护了一个数组+双向链表
    * 能够确保插入顺序和取出顺序
    * 第一次添加，扩容16

## Day33 P530-553

* Map

  * ![image-20210808091831465](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210808091831465.png)

  * value 可重复，但是key不可重复，会被最新的key取代。
  * 常用String 作为key
  * Key和value存在一对一映射关系
  * ![image-20210808093304545](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210808093304545.png)
    * 解释上图，key和value的引用放在set 和 collection中，但是真正的值存放在HashMap$Node中。key和value做成一对放在entry里，再把entry类型放在entrySet集合中
  * map常用方法
    * get(key)获取key对应的value值
    * put/remove/get/size/isEmpty/clear
    * containsKey()查找key是否存在
  * map六大遍历
    * valueSet()/keySet()/entrySet()

* HashMap

    * 常用接口：HashMap 频率最高/Hashtable/Properties
    * 没有实现同步，线程不安全
    * 不保证映射的顺序，底层是hash表
    * value 可重复，但是key不可重复，会被最新的key取代。
    * **底层机制和HashSet相同**

* HashTable

    * 实现map接口
    * 存放键值对，都不能为null
    * 使用方法基本和HashMap一样
    * 线程安全
    * 扩容机制
        * 初始化11，临界值0.75
        * 扩容\*2+1

* TreeSet

    * 使用无参构造器仍然无序
    * 有参构造器可以新建一个Comparator接口，赋给了TreeSet的底层的TreeMap的属性

* Properties
  * 继承hashtable
  * 还可以用于从xxx.properties文件中加载到Properties类中并进行读取，一般作为配置文件。
  
* 开发集合类选择

    * 判断存储类型（一组对象还是一组键值对）
        * 一组对象Collection接口
            * 允许重复：List
                * 增删多：LinkedList（维护双向链表）
                * 改查多：ArrayList（Obj类型的可变数组）
            * 不允许重复：Set
                * 无序：HashSet(底层是HashMao，维护了一个哈希表（数组+链表+红黑树）)
                * 排序：TreeSet 插入和取出顺序一致：LinkedHashSet，维护数组+双向链表
        * 一组键值对：Map
            * 键无序：HashMap（底层是：哈希表，jdk7数组+链表，jdk8数组+链表+红黑树）
            * 键有序：TreeMap
            * 插入和取出一致：LinkedHashMap
            * 读取文件 Properties

* Collection工具类  静态

    * reverse(list)翻转
    * shuffle（list）打乱
    * sort（list，new Comparator（））
    * max()，min（）;按照自然排序，返回给定集合中的最大（小）元素。**可以新建比较器。**
    * frequency（list，“tom”） 出现的次数
    * copy（list1，list2）把2付给1
    * replaceAll（list，“tom”，“汤姆”） 把tom换成汤姆

* HashSet的去重机制

    * hashcode()+equals()，底层存入对象，通过运算得到hash值，通过hash值得到对应的位置
    * 如果发现table索引所在的位置是空的，就直接存放
    * 如果有数据，进行equals比较【遍历比较】，比较后不相同，就加入。

* TreeSet的去重机制

    * 如果你传入一个comparator匿名对象，就使用实现的comparator去重。
    * 方法返回0，则相同，不添加
    * 如果没有传入匿名对象comparator，则以你添加的对象实现的compareable接口的compareTo去重。

* tips**典中典**

    * remove（对象）    // 定位的是对象的hash值，如果对象更改了，可能hash值就变了，就无法定位到删除对象了。
    * ![image-20210810182149871](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210810182149871.png)

## Day34 P554-574

* 泛型
  * 解决两个传统问题
    * 不能对加入集合ArrayList的数据类型进行约束
    * 遍历的时候，需要数据转换，如果集合中的数据量较大，对效率有影响。
  * 注意事项
    * E具体的数据类型在定义对象的时候指定，即在编译期间，确定E是什么类型。
    * 接口和类都可以，常用E、T（Type表示），**只能是引用类型**
    * 可以放入其子类
    * 如果不写，默认为Object
  
* 自定义泛型类

  * 使用泛型的数组，不能初始化
  * 方法不能static，静态是和类相关的，类加载的时候对象还没有创建。

* 自定义泛型接口

* 自定义泛型方法

  * ```  
    public<T,R> void fly(T t , R r)
    ```

* 泛型的继承和通配符

  * 不具备继承性
  * <?>：接受任意类型

## +++++TANK分界线+++++

* 画图

  * ```
    主类 extends JFrame；
    
    main方法
    
    让画布 = null
    
    //默认调用了
    主类的无参构造器（）｛
    	new 画布
    	画布加入窗口
    	设置关闭画布动作
    	显示画布
    ｝
    
    
    定义画布extend JPanel｛
    	paint方法（Graphics g）  //g可以理解为画笔
    	g.drawOval(尺寸)
    	
    	用方法接
    ｝
    ```

  * paint方法自动调用

    * 窗口最小化，再最大化
    * 窗口大小发生变化
    * repaint函数被调用

## Day35 P575-586

* 进程

  * 线程是进程的实体，相当高多个迅雷任务同时进行
  * 并发：单核cpu切换实现多任务
  * 并行：多核cpu实现多个任务同时进行

* 两种线程方法

  * Thread

    * 当一个类继承rhread类，就可以当做线程使用 
    * ![image-20210812145148783](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210812145148783.png)
    * 当主线程挂了之后thread线程如果没走完，还会继续走的。
    * 不用run，而用start，因为他有个方法start0()。由底层的JVM调用。  
    * **java为单继承模式，所以如果已经被继承了就不能再继承了，这时候要用Runnable接口**。

  * runnble

    * 使用了代理模式

    * ```
      //dog 继承了runnable
      Thread thread = new Thread（dog）；
      thread.start()
      ```

    * 实现接口的对象可以作为接口类型成为实参对象传入
  
## Day36 P587 - 595

  * 线程终止
  
    * 在方法中定义loop，并set，在主函数中增加时间，并使用set方法
  
  * 方法
  
    * t.interrupt中断休眠（也就是中断正在的sleep）
    * yield 线程的礼让，不一定礼让成功
    * join 线程的插队
    * 守护线程
      * 主线程结束，子线程也自动结束 
      * 方法：t.setDaemon(true)
  
* 线程的生命周期
      * ![image-20210813154338978](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210813154338978.png)
  * 线程同步机制  Synchronized
    * 保证数据在同一时刻，最多只有一个线程访问
  * 互斥锁
    * 保证数据的完整性，但是执行效率低
    * 非静态的，可以是this，也可以是其他对象
    * 静态的锁，为当前类本身。即为当前类.class 
  
## Day37 P596 - 604

  * 死锁
    * 两个锁都在占用
  * 当涉及到多个线程共享资源的时候，我们用接口Runnable

## Day38 605 - 609
* 线程销毁了并不意味这对象没了。
* 对象仍然还存在
* 坦克大战第四部分结束

##  Day39 610-626

* IO流

  * 文件在程序中是以流的形式操作的

  * ![image-20210818095816861](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210818095816861.png)

  * 创建的三种方式

    * ```
      File file = new file(filePath)
      File file = new file(parentFile,fileName)
      File file = 
      
      file.createNewFile()
      //只是new 并没有创建对象，只是在内存里。
      //只有create才是真正的在硬盘里创建对象。
      ```

    * 文件常用方法

      * getName/getAbsolutePath/getParent/exist/
      * length()内容字节。 一个汉字三个字节。
      * isFile/isDirectory  是不是一个文件/是不是一个目录
      * file.delete()  删除文件，返回布尔值
      * ==在java中，文件夹也属于文件==

  * 目录操作

    * 创建一级目录 file.mkdir() 就是磁盘后一个文件夹
    *  创建多级目录 file.mkdirs()

  * 流的分类

    * 按操作数据单位：字节流（8bit）二进制文件，字符流–文本文件
    * 按流向：输入流，输出流
    * 流的角色的不同：节点流，处理流/包装流
    * ![image-20210818105621353](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210818105621353.png)
* ![image-20210818110029263](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210818110029263.png)
  
    * ![image-20210818110505142](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210818110505142.png)

## Day40-42 627-661

* 字节流
  
  * FileInputStream
  
      * read（）字节流读取，汉字会乱码
      * 如果到文件结尾会返回-1，因此作为循环条件
      * read（byte[]），可以指定放入多大的字节进去。
    * FileOutputStream
      * new FileOutputStream(filePath)   //附加内容
      * new FileOutputStream(filePath,true)   //追加内容
    * write（b[] , start , end ）
  
* 字符流

    * fileReader
      * ![image-20210818194049967](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210818194049967.png)
      * 追加模式：后面加true
      * read：文件结尾返回-1.
    * fileWriter
      * 必须关闭close或者刷新flush，才能写入。
      * 在上面的两个底层才写入内容
    * ![image-20210818210213495](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210818210213495.png)
    * 节点流
      * 从一个特定的数据源进行读写数据
      * 底层/低级流，直接跟数据源相接
    * 处理流（包装流）
      * 多种数据源都可进行读写数据
      * 消除不同节点流的实现差异，也可以提供更方便的方法来完成输入输出。
      * **使用了修饰器设计模式，不会与数据源直接相连**
        * 通过子类继承父类，通过多态来实现父类下面的多种子类功能。
      * 优先：
        * 性能的提高：增加缓冲的方式提高输入输出的效率。
        * 操作的便捷：处理流可能提供了一系列便捷的方法来一次输入输出大批量数据。
      *  BufferedReader
        * **处理字符型**
        * bufferedReader.readLine 返回null时，表示文件读取完毕
        * 直接关闭外接口BufferedReader
        * newLine():插入一个换行
      * BufferedWriter
        * **处理字符型**
      * 处理字节流
        * BufferedInputerStream
        * BufferedOutputerStream
      * 序列化和反序列化
        - 序列化
          - 保存数据的值和数据类型
        - 反序列化
          - 恢复数据的值和数据类型
        - Serializable  //标记接口，没有方法，推荐。
        - Externalizable   有方法实现，不常用。
      * 对象处理流 
        * 保存int 100 ，同时把数据类型也保存进去
        * 保存对象，new dog（），且能恢复。
        * ObjectOutputerStream  ==保存序列化数据==
          * writeInt(100)
          * writeBoolean/writeChar/writeDouble/
          * writeUTF(“”)  写入的是String
          * **上述数据类型都继承了Serializable接口**
        * ObjectInputerStream  ==反序列化数据==
          * 按顺序读取 
          * dog对象用readObject，**此时dog的编译类型是Object**
          * 如果需要调用dog的方法，需要向下转型，且dog类要么做成公共类，要么在同一个java文件里
        * 注意事项
          * 读写顺序一致
          * 必须实现接口Serializable
          * 建议添加SerialVersionUID，提高版本的兼容性，但你修改对象的时候，他们人为你只是修改，而不是换了一个对象
          * static 和 transient 不能序列化
          * 属性序列化，里面的属性的类型也需要实现序列化接口。
        * 标准输入输出流
          * System.in  运行类型 bufferedInputerStream 
          * System.out  运行类型 bufferedOutputerStream, 
      * 转换流
        * 一般保存的是utf，如果用gbk就会乱码
        * 字节流可以转换编码格式
        * InputStreamReader /OutputStreamWriter 
          * 字节转字符，可以转编码
      * 字节打印流
        * PrintStream/
        * 只有输出，没有输入
        * ![image-20210819141802731](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210819141802731.png)
        * print 底层就是write
        * system.setOut()   //可以设置打印的位置
      * 字符打印流 PrintWriter
        * close 才是写入的时间
      * properties
        * load（dsr）
        * 默认为字符串
    * ==完成坦克基础==

## Day43  P662-669

* 网络相关概念
  * 网络覆盖分类：局域网，城域网，广域网
  
  * IP地址：唯一标识主机
    * IPV4常用
      * 4个字节，每个字节0-255
      * ip地址 = 网络地址（前三个字节）+主机地址
    * IPV6
      * IPv4的升级版
      * 解决网络地址资源数量有限的问题
    * ![image-20210822182837256](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210822182837256.png)
    
  * 域名
      * 解决记IP的困难
      * 将ip地址映射成域名
      
  * 端口
      * 标识某个特定的网络程序
      * 0-65535
      * **0-1024已经被占用**  ssh22，ftp21，smtp25 ，http80
      * 常见数据库
      * tomcat 8080 mysql3306 oracle1521 sqlserver1433
    * ![image-20210822184336745](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210822184336745.png)
    
  * 网络协议
  
      * 数据的组织形式就是协议，回复数据也需要按照规定好的协议方式
      * ![image-20210822191527956](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210822191527956.png)
  
      * ![image-20210822192143541](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210822192143541.png)
  
  * TCP/UDP
  
      * TCP 传输控制协议
          * 先TCP连接
          * 然后三次握手，确定可靠
          * 然后在进行**大数据**传输。
          * 传输完毕，释放连接，效率低
      * UDP用户数据协议
          * 数据、源、目的 封装数据包，不建立连接
          * 限制在64k
          * 不可靠
          * 速度快，不是面向连接的。
          * 例如发短信。
  
* InetAdress

  * 获得主机名或IP
  * 获得服务器域名或IP

* Socket

  * 套接字（Socket）开发网络应用程序被广泛采用，成为事实上的标准
  * 两端都要有
  * ![image-20210822201546592](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210822201546592.png)

## Day44  P670-679

* Socket
  * socket.shutdownOutput()  //对话结束标记
  * 也可以用writer.newLine()  //   另一端必须使用readLine（）   结束对话
  * 使用字符流一定记得刷新
* netstat
  *  -an 查看主机网络，包括端口监听和网络连接情况
  * -an|more 可以分页显示
  * dos控制台执行
  * -anb 可以查看哪个软件
* TCP连接的秘密
  * 客户端的端口连接是通过TCP/IP分配的，是不确定的，随机的。
* UDP网络通信（了解）
  * 没有服务端和客户端的概念
  * ![image-20210823171822536](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210823171822536.png)

## Day45 P680-709

* 项目开发流程
  * ![image-20210824094157507](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210824094157507.png)

* 多人通讯
  * 1. 用户登录
    2. 拉取在线用户
    3. 私聊
    4. 群聊
    5. 发文件
    6. 服务器推送新闻
  * ![image-20210824113313573](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210824113313573.png)

## Day46-49  复现上面的项目

## Day50 P711-722

* 反射
  * 不修改源码，扩容功能，即OCP模式
  * 在反射中，万物皆对象，方法也是对象
  * 反射机制
    * ![image-20210831115106798](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210831115106798.png)
    * 在运行时，判断任意对象所处的类
    * 在运行时，构造任意一个类的对象
    * 在运行时，得到任何一个类所具有的方法和成员变量
    * 在运用时，调用任意一个对象的成员方法和变量
    * **生成动态代理**
  * 反射相关的主要类
    * Class 代表一个类
    * Method  代表类方法
    * Field 代表类的成员变量
    * Constructor  代表类的构造方法，构造器
  * 优缺点
    * 优点是动态创建和使用对象（框架底层的核心）
    * 缺点，使用反射基本是解释执行，对执行速度有影响。
  * setAccessible 关闭访问检查
  * 通过loadClass类加载，然后生成了Class类
  * 重复的类对象，只加载一次
  * 类的实例会记得自己是哪一个class生成的
  * 类加载在堆里，还会生成类的字节码的二进制数据 
  
* 类加载
  * 静态加载：编译时加载相关的类，没有就报错
  * 动态加载：运行时加载需要的类 ，不用不会报错
  * ![image-20210831171646963](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210831171646963.png)
  * ![image-20210831172346351](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210831172346351.png)
  
* 类加载的三个阶段
  * 加载阶段：将字节码从不同的数据源中（可能是class文件，jar包，网络等）转化为**二进制字节流加载到内存中，并生成一个代表该类的java.lang.Class对象 **
  * 连接阶段
    * 验证：1.确保.class文件的字节流包含的信息符合虚拟机要求，==包括文件格式验证（是否以魔数oxcafebabe开头）、元数据的验证、字节码验证和符号引用验证==；可以考虑使用 -Xverity：none 关闭大部分的类验证措施，缩短时间。
    * 准备阶段：JVM会在该阶段进行静态变量，分配内存，进行默认初始化，一般为0，null，false；常量默认初始化就是为常量数值。
    * 解析阶段：**虚拟机将常量池内的符号引用替换为直接引用的过程**

## Day51 P723-731

* 初始化
  * 真正执行方法的过程

  * clinit（）方法收集对==静态变量==赋值，和==静态代码块中的语句==并进行合并

  * ==直接使用类的静态属性，也会导致类的加载==，哪怕不new一个实例。

  * clinit（）方法在多线程中会被正确的加锁、同步，保证只会有一个线程去执行这个类的clinit（）方法。

* 获取类结构信息API
  * 首先得到Class 对象
* getName：获得全类名
  * getSimpleName： 获得简单类名
  * getFields ：得到public修饰的属性列表
  * getDeclaredFields：本类所有属性
  * getMethods：本类public修饰的方法 
  * getDeclaredMethods：本类的所有方法 
  * getConstructors：本类及父类的public修饰的构造器
  * getDeclaredConstructors：本类及父类的所有的构造器
  * getPackage：以package形式返回包
  * getSuperClass ：返回父类信息
  * getInterfaces：以Class[]形式返回接口信息
  * ![image-20210901115053788](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210901115053788.png)
  * 通过反射创建对象
  * ![image-20210901115750082](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210901115750082.png)
    * newInstance（）创建的是无参构造器
    * getConstructor（String.class） 可以传入有参构造器，然后newInstance（）
    * 如果是私有的构造器/方法/属性，可以使用爆破  constructor.setAccessible(true)
  * 通过反射访问属性
    * ![image-20210901150104583](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210901150104583.png)
  * 通过反射访问成员方法
    * ![image-20210901150712164](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210901150712164.png)

##  Day52 P732-745

* 服务都是需要端口的
* mysql -h 主机名IP -P 端口 -u 用户名 -p密码
* 主机名（本机）  端口（3306）  可以不加有默认值
* ![image-20210902101226243](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210902101226243.png)
* CHARACTER SET 设置字符集
* COLLATE 设置校对规则 
* utf8_bin 区分大小写  utf8——general_ci默认，不区分大小写
* 如果表不设置字符集和校对规则，以数据库为准
* 反引号，规避关键词
* 备份与回复
  * 备份：mysqldump -u root -p B 库名 > 保存路径      需要在dos下执行
  * 单独备份某一个表  把B替换为 库  表名
  * 回复： source 保存路径   ，在Mysql命令行在执行 
* 数据类型
  * ![image-20210902201253747](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210902201253747.png)
  * ![image-20210902202046164](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210902202046164.png)
  * ![image-20210902201947448](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210902201947448.png)
  * 默认为有符号，后面加UNSIGNED 为有符号
* 小数类型使用
  * ![image-20210903092732239](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210903092732239.png)

## Day53 P746-758

* 字符串类型使用
  * ![image-20210903091253589](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210903091253589.png)
  * **注意，char是字符范围，VARCHAR是字节范围**
  * 如果是utf8  VARCHAR的范围就是65532-3   /3
  * 如果是gbk  VARCHAR的范围就是65532-3   /2
  * ==注释ctrl shift +C ，取消  +r==
  * char(4)  、VARCHAR(4)的  4  表示字符数，最大可以为255，无论是字母还是汉字，都只能最多放四个。
  * char （4）是定长，不用也会浪费，**varchar（4），不用不会浪费，但本身还需要1-3个字节来存放内容长度**
  * 如果定长用char，查询速度char更快
  * TEXT和varchar差不多，但是text没有默认值
* 修改表
  * ![image-20210903104424822](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210903104424822.png)
* 数据库CRUD
  * 如果列没有设置NOT NULL，那么可以设置为NULL
  * ` alter table ts01 rename to ts01_new`
  * UPDATE更新的是列
  * SET指定修改那个列，和要给予哪些值
  * WHERE子句指定应更新哪些行，不然所有行的对象全部更新
  * DELETE FROM 表格  [WHERE 列]
  * DELETE 可以把每一行的删除，不可以列的某个元素删除，可以设置为null 或者‘ ’
  * DELETE只能删除内容，DROP才能删除表格
  * SELECT
    * SELECT DISTINCT 列名 FROM 表格  表示完全一致的字段会被去重。
    * SELECT columnname  AS 别名 from 表名
    * ![image-20210903165044495](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210903165044495.png)
    * SELECT *  FROM 表名 WHERE 条件
    * BETWEEN AND 闭环条件
    * IN（80，90，100）；
    * 查询所有姓李的同学 `WHERE`  name LIKE ‘李%’
    * ORDER BY 列名（别名）DESC(ASC)
    * WHERE 时间>时间，  时间也可以直接比较
    * 显示第三个字符为大写o  WHERE XX LIKE ‘__o%’两个下划线。

## Day54 P759-773

* 合计/统计函数

  *  ```
    SELECT COUNT(*) FROM 表名 WHERE 条件
    ```

  * COUNT(*)和COUNT(列) 列会排除null行

* SUM函数

  * ```
    SELECT SUM(math) FROM student 
    ```

  * 只对数值有用

* 合计函数— MAX/MIN

* 平均函数— AVG

* 分组统计

  * 比如按照部门来分组查询

  * ```
    SELECT AVG(`SAL`),MAX(`SAL`),`deptno`
    	FROM emp GROUP BY `deptno`
    		HAVING 条件
    ```

* 字符串相关函数

  * ![image-20210906122815332](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210906122815332.png)
  * DUAL 亚元表，系统表

* 数学相关函数

  * ```
    ABS(num);
    BIN(10) 十进制转二进制
    CEILING(number2) 向上取整，返回比number2大的最小整数
    FLOOR(number2) 向下取整，返回比number2小的最大整数
    FORMAT(2) 保留2位小数（最后一位四舍五入）
    LEAST(0,-1,2) 返回最小值
    SELECT CONV(8,10,2) 把十进制的8转为2进制
    MOD（10，3）求余数
    RAND(seed)  随机数 
    ```

* 时间日期的相关函数

  * ![image-20210906160115980](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210906160115980.png)
  * ![image-20210906163631981](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210906163631981.png)

* 加密函数

  * ```
    USER()
    DATABASE()数据库名称
    MD5(密码) 加密，常用用户密码加密
    PASSWORD(str)
    ```

* 流程控制函数

  * ```
    SELECT CASE
    	WHEN   ...  THEN   ...
    	WHEN   ...  THEN   ...
    	ELSE   ...  END
    ```

* 多表查询

  * ```
    LIMIT 起始页，显示页数
    顺序一般是group by，having，order by，limit
    ```
## Day55 P773-785

* 多表查询

  * 笛卡尔集 ：第一个表的第一行连接第二个表的所有行，连接表共有m*n的数据

  * 连接时，如果名字一样，需要表明哪个表

  * 连接用WHERE，用相同列连接   

  * 自连接

    * 将同一张表看做两张表

    * ```
      SELECT woker.ename AS 别名 ，boss.enname AS '别名'
      		FROM emp 别名 ，emp 别名
      		WHERE woker.mgr = boss.empno
      		
      		//重点 列起一个别名，表一定要起一个别名
      ```

  * 多行子查询

    * 嵌套SELECT ，使用关键字IN

  * 多列子查询

    * WHERE(元素)｛SELECT嵌套｝

  * ALL / ANY 的使用

    * ALL比所有的还
    * ANY比任意一个还 

  * 自我复制（蠕虫复制）

    * 创建海量数据
    * insert into 自己的所有元素
    * CREATE TABLE 表名 LIKE 另一个表名   复制结构

  * 表复制

    * ```
      创建临时表temp，结构一样table
      将table的记录通过distinct处理，复制到temp
      删除table的记录  （删除表，rename）
      复制内容
      删除临时表
      ```

  * 合并查询

    * union all 结果合并，不会去重
    * union 结果合并，会去重

  * 左右外连接

    * 使用左连接：`SELECT .. FROM 表1 LEFT JOIN 表2 ON 条件`
    * 即倘若两个表格有未连接的，也会将左表信息全部链接，内容为null
    * 右外连接同理
    * 不是很常用

  * mysql约束

    * 主键 primary key
      * 不能重复和null
      * `id INT RPIMAYY KEY`
      
      * 一张只能有一个主键，可以使用复合主键 primary key（‘’id‘’，‘’name‘’）
      * 使用复合键就是两个必须同时相等才算

## Day56 P786-792

*  mysql约束
  * not null 非空
  * unique
    * 不能重复，可以为多个null
    * 可以使用多个unique
    * unique not null  几乎等同于primary key
  
* 外键
  * ![image-20210912155931759](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210912155931759.png)
  * 只要一个学生表（从表）连接了的班级表（主表），那么主表的那一行数据就无法删除，除非从表内容无了。
  * ` foreign key（本字段）references 主表名（字段）`
  * 主表的连接键要做成unique 或者primary key主键
  * 在从表里指定外键关系
  * 引擎必须是innodb
  * 外键字段的值，必须在主键字段中出现过，或者为null（==前提外键字段允许为空==）
  
* check
  * 定义字段的条件范围
  * 但是mysql5.7不支持，可以做语法校验，但是不会生效。
  
* ENUM
  * 枚举，定义字段的时候使用
  * 支持
  
* 总结外键约束
  * 相当于父类继承的感觉，又有点二叉树的感觉
  * 不能没有爸爸就有儿子
  * 记得定义字段的时候为`字段名+数据类型+约束+default`、
  
*  自增长

   * 一般都是当做序号用

   *  字段名 数据类型 primary key auto_increment =100（从100开始，不加默认为1）
   *  insert into 表名（字段1，字段2…）values(==null==,’值’)

## Day57 P793-820

* 索引

  * 索引的原理

    * 没有索引：全表扫描，很慢
    *  有索引：形成一个索引的数据结构，比如二叉树。
    * 二叉树如果查询20次，相当于有2的30次方的数据
    * ![image-20210913094759506](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210913094759506.png)

  * 索引的代价

    * 形成的数据结构会占用内存
    * 对dml（改update删delete插insert）语句的效率影响
    * 因为二叉树的结构会改变

  * 创建索引机制

    * primary key  主键索引，主键自动为主索引

    * unique 也是索引

    * 普通索引 INDEX

      * ```
        //查询是否有索引
        show indexes from 表名
        //添加唯一索引
        create unique index 表名 on 字段名
        //添加普通索引
        create index 表名 on 字段名
        alter table 表名 add index 字段名
        //如果不重复，优先使用唯一索引
        
        //添加主键索引
        alter table 表名 add primary key（字段名）
        //删除索引
        drop index id_index on 表名
        //删除主键索引
        alter table 表名 drop primary key
        
        //查询索引
        show index from 表名
        show indexes from 表名
        show keys from 表名
        desc 表名  （显示mul）信息不详细
        ```

  * 注意事项

    * 较频繁搜索的应该创建
    * 唯一性很差的不适合，比如性别
    * 更新很频繁的不适合 

* mysql事务

  * 把多个dml当做一个整体，要么都成功，要么都失败。

  * 流程

    * ```
      start transaction/set autocommit = off
      -- 设置保存点
      savepoint a 
      --进行dml
      savepoint b
      --进行dml
      --回退b
      rollback b
      --回退a
      rollback a
      --如果直接写rollback，直接回滚到起点
      
      --如果直接回滚到a，就不能再回滚到b了
      --commit 结束事务/提交事务
      --所有的事务失效，其他连接可以查看事务变化后的新数据。
      ```

  * 细节

    * 需要在innodb的存储引擎才可以使用，myisam不好使

* 事务隔离级别

  * 脏读：当一个事务读取另一个事务尚未提交的修改时，产生脏读

  * 不可重复读：由于其他提交事务所做的==修改或者删除==，导致每次返回的内容都不一样（**我不希望受到其他事务的影响**）

  * 幻读：由于其他提交事务所做的==插入==操作，每次返回的结果都不同。

  * ![image-20210913105622324](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210913105622324.png)

  * ```
    --查看当前mysql的隔离级别
    select @@tx_isolation
    --查看系统的隔离级别
    select @@global_tx_isolation
    
    --设置当前隔离级别
    set session transaction isolation level 隔离级别
    --设置系统隔离级别
    set global transaction isolation level 隔离级别
    --系统默认级别是repeatable read ，一般没有必要需求，不修改
    --可以在my.ini中设置默认隔离级别
    transaction-isolation = 隔离级别
    ```

  * 可串行化serializable 加锁，其他事务正在操作或者进行mdl时，本方事务不能操作，会卡在那里，等对方提交了才能看到

  * dos使用数据库

    * ```
      mysql -u root -p
      use 数据库名称
      ```

* ![image-20210913114536021](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210913114536021.png)

* 存储引擎

  * ![image-20210913151224843](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210913151224843.png)

  * ![image-20210913152125400](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210913152125400.png)

  * 如何选择

    * 不需要事务，处理的是基本的CRUD操作，那么myisam是不二选择，速度快。
    * 支持事务，innodb
    * memory，数据存储在内存中，速度极快。但是由于是内存存储引擎，所做的任何修改都会在服务器重启后消失。（经典用法==用户的在线状态==）

  * 修改存储引擎

    * ```
      ALTER TABLE 表名 ENGINE = INNODB
      ```

* 视图

  * 视图来自基表，是虚拟的表

  * 视图也有列

  * 通过视图可以修改基表

  * 基表的改变，也会影响到视图的数据

  * 使用细节

    * ```
      --创建一个视图，会产生一个.frm文件
      create view 视图名
      	as
      	select 字段名 from 表名
      	
      --改变视图
      alter view 视图名 
      	as
      	select 字段名 from 表名
      	
      --显示
      show create view 视图名
      --删除
      drop view 视图名
      ```

    * 视图中可以继续使用视图

    * ![image-20210913161308976](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210913161308976.png)

* 创建用户

  * ```
    --创建用户
    create user '用户名'@'ip地址' identified by '密码'
    
    --删除用户
    drop user '用户名'@'ip地址'
    
    --修改密码
    set password = password（‘123456’） 
    ```

  * 不同的数据库，操作的库和表不相同。

  * ![image-20210913170021376](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210913170021376.png)

  * 回收用户授权

    * ```
      revoke 权限列表 on 库.对象名 from '用户名'@'ip地址'
      ```

  * 细节
    * 创建用户时不指定host，则为%，表示所有的ip都有连接权限。可以直接删除。
    * 也可以指定‘192.168.1.%’

* mysql细节

  * as别名 可以不写as
  * null只能用is 不能用其他
  * 求月的倒数几天可以用函数`last_day-n`
  * 不含有某个字母` not like '%k%'`
  * `floor()`忽略余数，` round()`四舍五入
  * `group by .. having`

## Day58 P821-

* jdbc的原理示意图

  * ![image-20210914095053685](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210914095053685.png)

  * 编写过程

    * 注册驱动 - 加载Driver类
    * 获取连接 - 得到connection
    * 执行增删改查 - 发送sql给mysql执行
    * 释放资源

  * 连接方式

    * ```
      //方式一：常规方法
      //方法二：利用反射进行driver 的动态加载
      Class<?> aClass = Class.forName(com.mysql.jdbc.Driver)
      Driver driver = (Driver)aClass.newInstance()
      //方式三：driverManager
      DriverManager.registerDriver(driver);
      DriverManager.getConnect(url,propertise)
      //方式四：加载driver类时，自动完成注册
      Class.forName(com.mysql.jdbc.Driver)
      DriverManager.getConnect(url,propertise)
      //方式五：无需反射driver
      //5.1.6后的mysql驱动直接自动注册加载
      //方式6：通过propert文件
      new properties（）
      ```

  * 查询方式

    * ```
      Statement statement = connect.createStatement()
      
      ResultSet resultSet = statement.executeQurey()
      
      while(resultSet.next){ //光标一行一行移动，最后之后为false
      resultSet.getInt(1) 第一列
      //...
      }
      ```

  * sql注入问题

    * 我们不用statement，一般用preparedStatement。

    * 因为statement有sql注入风险

    * 什么是sql注入：某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法的sql语句段或者命令，恶意攻击数据

    * ```
      //输入用户名为  1' or
      //输入密码为 or '1'='1'
      ```

  * preparedStatement

    * ```
      String sql = "select name ,pwd form admin where name = ? and pwd = ?"
      ..
      preparedStatement.setString(1,admin_name);
      
      ```
  
  * jbdc API
  
    * ![image-20210914162348415](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210914162348415.png)
    * ![image-20210914162426995](https://tuchuang-1306197151.cos.ap-shanghai.myqcloud.com/typora本地图床/image-20210914162426995.png)

* 异常处理

  * 我们通常将编译异常转成运行异常

  * 调用者可以选择捕获该异常，也可以选择默认处理该异常。

  * ```
    throw new RuntimeException（e）
    ```

* jbdc流程小总结 

  * ```
    //驱动
    //设置url，properties
    //通过drivermanage获得 connect
    //设置处理sql
    //通过connect.prepareStatement获取预处理并输入sql获取preparedStatement对象
    //查询用executeQuery、修改用executeUpdate
    //关闭
    ```

* jdbc事务

  * 默认connect执行后自动提交事务

  * ```
    connect.setAutoCommit(false)
    //在catch中设置 rollback
    ```

  * 