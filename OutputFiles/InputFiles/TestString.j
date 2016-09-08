.class public TestString
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static abc Ljava/lang/String;
.field private static i I
.field private static index I
.field private static sub Ljava/lang/String;
.field private static temp Ljava/lang/String;

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
    ldc "dog"
    putstatic TestString/abc Ljava/lang/String;
    getstatic TestString/abc Ljava/lang/String;
invokevirtual java/lang/String.length()I
    putstatic TestString/i I
    ldc "Size "
    getstatic TestString/i I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Size "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestString/i I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    ldc "b"
    putstatic TestString/temp Ljava/lang/String;
    getstatic TestString/abc Ljava/lang/String;
    getstatic TestString/temp Ljava/lang/String;
invokevirtual java/lang/String.indexOf(Ljava/lang/String;)I
    putstatic TestString/index I
    ldc "Index "
    getstatic TestString/index I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Index "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestString/index I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    getstatic TestString/abc Ljava/lang/String;
    ldc 0
    ldc 1
invokevirtual java/lang/String.substring(II)Ljava/lang/String;
    putstatic TestString/sub Ljava/lang/String;
    ldc "Substring "
    getstatic TestString/sub Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Substring "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestString/sub Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop

return
.limit locals 32
.limit stack 40
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	TestString/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	TestString/_standardIn LPascalTextIn;

 new TestString
    dup
    invokespecial TestString/<init>()V
    invokevirtual TestString/main()V

    getstatic	TestString/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
