.class public TestIfList
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a Ljava/util/ArrayList;
.field private static b I
.field private static c I
.field private static i I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
new  List
dup
astore_0
aload_0
invokespecial List.<init>()V
invokevirtual List/ListInteger()Ljava/util/ArrayList;
putstatic TestIfList/a Ljava/util/ArrayList;
aload_0
    ldc 1
invokevirtual List/add(I)V
aload_0
    ldc 2
invokevirtual List/add(I)V
    ldc 0
    putstatic TestIfList/i I
aload_0
    ldc 0
invokevirtual List/getValInteger(I)I
    putstatic TestIfList/b I
    ldc "Val "
    getstatic TestIfList/b I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestIfList/b I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    getstatic TestIfList/i I
    ldc 1
    iadd
    putstatic TestIfList/i I
aload_0
    getstatic TestIfList/i I
invokevirtual List/getValInteger(I)I
    putstatic TestIfList/c I
    ldc "Val "
    getstatic TestIfList/c I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestIfList/c I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
aload_0
    getstatic TestIfList/i I
invokevirtual List/getValInteger(I)I
    ldc 4
    if_icmpgt L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifeq L006
    ldc "two is less than four"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "two is less than four"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    goto L00100
L006:
aload_0
    getstatic TestIfList/i I
invokevirtual List/getValInteger(I)I
    ldc 2
    if_icmpge L007
    iconst_0
    goto L008
L007:
    iconst_1
L008:
    ifeq L009
aload_0
    getstatic TestIfList/i I
invokevirtual List/getValInteger(I)I
    ldc 1
    if_icmpgt L009
    iconst_0
    goto L0010
L009:
    iconst_1
L0010:
    ifeq L0012
    ldc "two greater than one"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "two greater than one"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    goto L00100
L0012:
    iconst_1
    ifeq L0013
    ldc "not here"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "not here"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
L0013:
L00100:
    goto L00101
L0015:
    iconst_1
    ifeq L0016
    ldc "else should always work"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "else should always work"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
L0016:
L00101:

return
.limit locals 32
.limit stack 40
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	TestIfList/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	TestIfList/_standardIn LPascalTextIn;

 new TestIfList
    dup
    invokespecial TestIfList/<init>()V
    invokevirtual TestIfList/main()V

    getstatic	TestIfList/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
