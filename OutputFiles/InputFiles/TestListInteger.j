.class public TestListInteger
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a Ljava/util/ArrayList;
.field private static b I
.field private static c I
.field private static d I

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
putstatic TestListInteger/a Ljava/util/ArrayList;
aload_0
    ldc 1
invokevirtual List/add(I)V
aload_0
    ldc 2
invokevirtual List/add(I)V
aload_0
    ldc 0
invokevirtual List/getValInteger(I)I
    putstatic TestListInteger/b I
    ldc "Val "
    getstatic TestListInteger/b I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestListInteger/b I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
aload_0
    ldc 1
invokevirtual List/getValInteger(I)I
    putstatic TestListInteger/c I
    ldc "Val "
    getstatic TestListInteger/c I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestListInteger/c I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
aload_0
    ldc 2
invokevirtual List/remove(I)V
aload_0
    ldc 0
    ldc 3
invokevirtual List/setVal(II)V
aload_0
    ldc 3
invokevirtual List/getIndex(I)I
    putstatic TestListInteger/d I
    ldc "Val "
    getstatic TestListInteger/d I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestListInteger/d I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
aload_0
invokevirtual List/getSize()I
    putstatic TestListInteger/d I
    ldc "Val "
    getstatic TestListInteger/d I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestListInteger/d I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
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
    putstatic	TestListInteger/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	TestListInteger/_standardIn LPascalTextIn;

 new TestListInteger
    dup
    invokespecial TestListInteger/<init>()V
    invokevirtual TestListInteger/main()V

    getstatic	TestListInteger/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
