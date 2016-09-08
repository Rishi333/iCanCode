.class public TestFor
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a I
.field private static b Z
.field private static i I
.field private static j I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
    ldc 5
    putstatic TestFor/a I
    ldc "Above for looop"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Above for looop"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc 1
    putstatic TestFor/b Z
    ldc 3
    ldc 5
    if_icmplt L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifeq L006
    ldc 0
    putstatic TestFor/i I
L10:
    getstatic TestFor/i I
    ldc 10
    if_icmplt L006
    iconst_0
    goto L007
L006:
    iconst_1
L007:
    ifne L008
    goto L009
L008:
    ldc 3
    ldc 5
    if_icmplt L0028
    iconst_0
    goto L0029
L0028:
    iconst_1
L0029:
    ifeq L0031
    ldc 0
    putstatic TestFor/j I
L20:
    getstatic TestFor/j I
    ldc 10
    if_icmplt L0031
    iconst_0
    goto L0032
L0031:
    iconst_1
L0032:
    ifne L0033
    goto L0034
L0033:
    ldc "Printing Numbers "
    getstatic TestFor/i I
    getstatic TestFor/j I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Printing Numbers "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestFor/i I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    getstatic TestFor/j I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    pop
    getstatic TestFor/j I
    ldc 1
    iadd
    putstatic TestFor/j I
    goto L20
L0034:
    goto L00100
L0053:
L00100:
    getstatic TestFor/i I
    ldc 1
    iadd
    putstatic TestFor/i I
    goto L10
L009:
    goto L00101
L0055:
L00101:
    ldc "Below Forloop"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Below Forloop"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop

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
    putstatic	TestFor/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	TestFor/_standardIn LPascalTextIn;

 new TestFor
    dup
    invokespecial TestFor/<init>()V
    invokevirtual TestFor/main()V

    getstatic	TestFor/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
