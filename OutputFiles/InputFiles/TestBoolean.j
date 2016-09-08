.class public TestBoolean
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a I
.field private static b I
.field private static c Z

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
    ldc 1
    putstatic TestBoolean/a I
    ldc 6
    putstatic TestBoolean/b I
    ldc 1
    putstatic TestBoolean/c Z
L10:
    getstatic TestBoolean/c Z
    ldc 1
    if_icmpeq L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifne L005
    goto L006
L005:
    ldc "In While loop "
    getstatic TestBoolean/a I
    getstatic TestBoolean/b I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "In While loop "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestBoolean/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    getstatic TestBoolean/b I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    pop
    getstatic TestBoolean/a I
    ldc 1
    iadd
    putstatic TestBoolean/a I
    getstatic TestBoolean/b I
ldc 1
    isub
    putstatic TestBoolean/b I
    ldc 0
    putstatic TestBoolean/c Z
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
    putstatic	TestBoolean/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	TestBoolean/_standardIn LPascalTextIn;

 new TestBoolean
    dup
    invokespecial TestBoolean/<init>()V
    invokevirtual TestBoolean/main()V

    getstatic	TestBoolean/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
