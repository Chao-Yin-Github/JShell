# Jshell

A self-made shell command , written by Java.

<p align="center">
<a href="https://img.shields.io/badge/Java-v1.8.0-red?style=plastic"><img src="https://img.shields.io/badge/Java-v1.8.0-red?sytle=plastic"></a>
<a href="https://img.shields.io/badge/tools-shell-darkgrey?sytle=plastic"><img src="https://img.shields.io/badge/tools-shell-darkgrey?sytle=plastic"></a>
<a href="https://img.shields.io/badge/Platform-Manjaro 19.0.1 Kyria-blue?sytle=plastic"><img src="https://img.shields.io/badge/Platform-Manjaro 19.0.1 Kyria-blue?sytle=plastic"></a>
<a href="http://47.100.76.82"><img src="https://img.shields.io/badge/blog-yc-yellow?sytle=plastic"></a>
<a href="mailto:yinchao.mail@foxmail.com"><img src="https://img.shields.io/badge/contact me-yinchao.mail@foxmail.com-brightgreen?sytle=plastic"></a>
</p>

---
## What command has been completed

- echo

- grep

- pwd

- ls

- cd

- cat

- mkdir

- cp

- echo | grep

    pipeline operation

---
## Waiting to be improved

- Echo and grep commands do not implement quotes match

- The command `|` is not implemented, this requires pipelined programming

- Grep command does not use regular expressions is what needed to be improved

## Feature

- A special Pwd class is used to maintain the work path, instead of using the system work path

   专门用到了一个Pwd类维护工作路径,而非使用系统的工作路径

	```java
	System.getProperty("user.dir")
	```

    reason:
    
    > Calling System.setProperty("user.dir","xxx") to modify user.dir can affect the subsequent creation of java.io.File and java.nio.file.path,but it will not affect java.io.FileOutputStream, java.lang.Process,etc.
    That is, the current directory is stiill for writing files, child Process etc, which will not be modified with the pace of the modification of system attributes.

    >调用System.setProperty(" user.dir ", " xxx ")修改user.dir后，能影响java.io.File和java.nio.file.Path的后续创建，但不会影响java.io.FileOutputStream、java.lang.Process等，即写入文件、子进程等当前目录还是进程启动时的目录，不会随系统属性的修改而修改。

- A custom Exception class: ArgumentsException is created, and the utility class CheckArguments is used to detect input parameters.

    建立了一个自定义的异常类ArgumentsException，并使用工具类CheckArguments检测输入参数，方便有效，逼格也高。

- Handle the problem of \n cannot be escaped to newLine

    \n不能转义为换行符的问题。

	[Java escape character](https://www.runoob.com/java/java-regular-expressions.html)

    In java, `\\` means : I want to insert a regular expression backslash, so the characters after it have a special meaning.(While other languages only need a back)

    在Java中，`\\` 表示：我要插入一个正则表达式的反斜线，所以其后的字符具有特殊的意义。(而其他语言只需要一个反斜杠即可)

    So, in other languages (such as Perl), a backslash `\` is sufficient to escape, while in Java regular expressions need two backslash to be parsed into Escape effect.

    所以，在其他的语言中（如Perl），一个反斜杠 `\` 就足以具有转义的作用，而在 Java 中正则表达式中则需要有两个反斜杠才能被解析为其他语言中的转义作用。

    We can also simply understand that in Java's regular expressions, tow `\\` represent one `\`, which is the reason why regular expression representing a number is `\\d` and a normal backslash is `\\\\`.

    也可以简单的理解在 Java 的正则表达式中，两个`\\`代表其他语言中的一个`\`，这也就是为什么表示一位数字的正则表达式是 `\\d`，而表示一个普通的反斜杠是 `\\\\`。

## License
<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">JShell</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="https://github.com/Chao-Yin-Github/JShell" property="cc:attributionName" rel="cc:attributionURL">https://github.com/Chao-Yin-Github/JShell</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.
