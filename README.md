# XinKongTools
个人工具
######
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

[![](https://jitpack.io/v/huangxunlei/XinKongTools.svg)](https://jitpack.io/#huangxunlei/XinKongTools)

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}

Step 2. Add the dependency

	dependencies {
	        compile 'com.github.huangxunlei:XinKongTools:1.0.1'
	}
###
1.	需要添加的内容
*  圆角图片 CircleImageView  库
* 待删除按钮的EditText
* ViewPagerAdapter的基类
* BaseActivity和BaseFragment