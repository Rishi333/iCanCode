.class public TestSet
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a Ljava/util/HashSet;
.field private static b Z
.field private static c I
.field private static s I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
new Set
dup
astore_0
aload_0
invokespecial Set.<init>()V
    ldc 3
    ldc 5
    iadd
invokevirtual Set/SetInteger(I)Ljava/util/HashSet;
putstatic TestSet/a Ljava/util/HashSet;
    ldc 3
    putstatic TestSet/c I
aload_0
    getstatic TestSet/c I
invokevirtual Set/add(I)V
aload_0
    getstatic TestSet/c I
    ldc 1
    iadd
invokevirtual Set/add(I)V
aload_0
    getstatic TestSet/c I
invokevirtual Set/contains(I)Z
    putstatic TestSet/b Z
    ldc "Contains "
    getstatic TestSet/b Z

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Contains "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestSet/b Z
    invokevirtual java/lang/StringBuilder/append(Z)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
aload_0
invokevirtual Set/getSize()I
    putstatic TestSet/s I
    ldc "Size "
    getstatic TestSet/s I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Size "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestSet/s I
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
    putstatic	TestSet/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	TestSet/_standardIn LPascalTextIn;

 new TestSet
    dup
    invokespecial TestSet/<init>()V
    invokevirtual TestSet/main()V

    getstatic	TestSet/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
