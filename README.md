# XinKongTools
个人工具
######
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
```
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.huangxunlei:XinKongTools:1.0.1'
	}