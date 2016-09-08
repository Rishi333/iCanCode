.class public TestListString
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a Ljava/util/ArrayList;
.field private static b Ljava/lang/String;
.field private static c Ljava/lang/String;
.field private static d I
.field private static name Ljava/lang/String;
.field private static pos I

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
invokevirtual List/ListString()Ljava/util/ArrayList;
putstatic TestListString/a Ljava/util/ArrayList;
    ldc "abc"
    putstatic TestListString/name Ljava/lang/String;
aload_0
    getstatic TestListString/name Ljava/lang/String;
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "cde"
invokevirtual List/add(Ljava/lang/String;)V
    ldc 0
    putstatic TestListString/pos I
aload_0
    getstatic TestListString/pos I
invokevirtual List/getValString(I)Ljava/lang/String;
    putstatic TestListString/b Ljava/lang/String;
    ldc "Val "
    getstatic TestListString/b Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestListString/b Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
aload_0
    ldc 1
invokevirtual List/getValString(I)Ljava/lang/String;
    putstatic TestListString/c Ljava/lang/String;
    ldc "Val "
    getstatic TestListString/c Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestListString/c Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
aload_0
    ldc "cde"
invokevirtual List/remove(Ljava/lang/String;)V
aload_0
    getstatic TestListString/pos I
    ldc "what"
invokevirtual List/setVal(ILjava/lang/String;)V
aload_0
    ldc "what"
invokevirtual List/getIndex(Ljava/lang/String;)I
    putstatic TestListString/d I
    ldc "Val "
    getstatic TestListString/d I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestListString/d I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
aload_0
invokevirtual List/getSize()I
    putstatic TestListString/d I
    ldc "Val "
    getstatic TestListString/d I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestListString/d I
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
    putstatic	TestListString/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	TestListString/_standardIn LPascalTextIn;

 new TestListString
    dup
    invokespecial TestListString/<init>()V
    invokevirtual TestListString/main()V

    getstatic	TestListString/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
