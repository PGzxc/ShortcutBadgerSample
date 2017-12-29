# 应用未读消息图标
# 前言

应用角标是iOS的一个特色，原生Android并不支持。在项目开发的过程中，项目需求在手机桌面图标上显示新消息条数的角标，桌面角标的功能在原生android系统中是没有提供此类API的，只有第三方深度定制过的android系统才有此类功能，如：三星、小米、魅族、华为等，但问题又来了，每家定制使用的方法又只不相同，我们一般使用第三方开源的项目来实现。  

这里提供两个Github上的项目：  
[https://github.com/leolin310148/ShortcutBadger][1]     
[https://github.com/xuyisheng/ShortcutHelper][2]   
这里以ShortcutBadger为例进行解读   
<!--more-->

# 如何使用  
## 添加依赖支持 

	compile "me.leolin:ShortcutBadger:1.1.13@aar"
![][3]
## 添加消息角标

	ShortcutBadger.applyCount(context, number);
![][4]
## 移除消息 

	boolean isRemoveSuccess = ShortcutBadger.removeCount(this);	

![][5]
# 权限问题
有些手机上无法生效，无意发现申请了 <uses-permission android:name="android.permission.INTERNET" /> 之后就解决了

# 效果 
如图是lg上的显示效果  
![][6]    

参考：   
[Android上的Badge，快速实现给应用添加角标][7]

  

[1]: https://github.com/leolin310148/ShortcutBadger
[2]: https://github.com/xuyisheng/ShortcutHelper
[3]: http://p0kng3270.bkt.clouddn.com/shortcut.png
[4]: http://p0kng3270.bkt.clouddn.com/shortcut-add.png
[5]: http://p0kng3270.bkt.clouddn.com/shortcut-reduce.png
[6]: http://p0kng3270.bkt.clouddn.com/lg.png
[7]: https://www.cnblogs.com/dmtyoung/p/6477531.html
