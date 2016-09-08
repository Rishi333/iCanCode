.class public TestWhile
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a I
.field private static b I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
    ldc 1
    putstatic TestWhile/a I
    ldc 6
    putstatic TestWhile/b I
L10:
    getstatic TestWhile/a I
    ldc 4
    if_icmplt L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifne L005
    goto L006
L005:
L20:
    getstatic TestWhile/b I
    ldc 3
    if_icmpgt L0015
    iconst_0
    goto L0016
L0015:
    iconst_1
L0016:
    ifne L0017
    goto L0018
L0017:
    ldc "In While loop "
    getstatic TestWhile/a I
    getstatic TestWhile/b I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "In While loop "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestWhile/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    getstatic TestWhile/b I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    pop
    getstatic TestWhile/a I
    ldc 1
    iadd
    putstatic TestWhile/a I
    getstatic TestWhile/b I
ldc 1
    isub
    putstatic TestWhile/b I
    goto L20
L0018:
    goto L10
L006:

return
.limit locals 32
.limit stack 40
.end method

.method public second()V

return
.limit locals 32
.limit stack 40
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	TestWhile/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	TestWhile/_standardIn LPascalTextIn;

 new TestWhile
    dup
    invokespecial TestWhile/<init>()V
    invokevirtual TestWhile/main()V

    getstatic	TestWhile/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
