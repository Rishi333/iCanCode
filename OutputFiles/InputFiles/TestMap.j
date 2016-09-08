.class public TestMap
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a Ljava/util/HashMap;
.field private static abc Ljava/lang/String;
.field private static b I
.field private static pos I
.field private static siz I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
new Map
dup
astore_0
aload_0
invokespecial Map.<init>()V
invokevirtual Map/StringIntegerMap()Ljava/util/HashMap;
putstatic TestMap/a Ljava/util/HashMap;
    ldc "abc"
    putstatic TestMap/abc Ljava/lang/String;
    ldc 4
    putstatic TestMap/pos I
aload_0
    getstatic TestMap/abc Ljava/lang/String;
    getstatic TestMap/pos I
invokevirtual Map/addStringInteger(Ljava/lang/String;I)V
aload_0
    ldc "cde"
    getstatic TestMap/pos I
invokevirtual Map/addStringInteger(Ljava/lang/String;I)V
aload_0
    ldc "cde"
invokevirtual Map/remove(Ljava/lang/String;)V
aload_0
    getstatic TestMap/abc Ljava/lang/String;
invokevirtual Map/getValStringInteger(Ljava/lang/String;)I
    putstatic TestMap/b I
    ldc "B is "
    getstatic TestMap/b I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "B is "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestMap/b I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
aload_0
invokevirtual Map/getSize()I
    putstatic TestMap/siz I
    ldc "Size is "
    getstatic TestMap/siz I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Size is "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestMap/siz I
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
    putstatic	TestMap/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	TestMap/_standardIn LPascalTextIn;

 new TestMap
    dup
    invokespecial TestMap/<init>()V
    invokevirtual TestMap/main()V

    getstatic	TestMap/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
