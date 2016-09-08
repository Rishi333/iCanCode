.class public SampleProgram2
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a Ljava/util/ArrayList;
.field private static currentOccurrence I
.field private static desc Ljava/lang/String;
.field private static i I
.field private static name Ljava/lang/String;
.field private static occurrences Ljava/util/HashMap;
.field private static size I
.field private static temp Ljava/lang/String;
.field private static test Z

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

new  List
dup
astore_0
aload_0
invokespecial List.<init>()V
invokevirtual List/ListString()Ljava/util/ArrayList;
putstatic SampleProgram2/a Ljava/util/ArrayList;
    ldc "a"
    putstatic SampleProgram2/name Ljava/lang/String;
aload_0
    getstatic SampleProgram2/name Ljava/lang/String;
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "b"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "b"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "c"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "c"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "c"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "c"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "d"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
    ldc "e"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
invokevirtual List/getSize()I
    putstatic SampleProgram2/size I
new Map
dup
astore_3
aload_3
invokespecial Map.<init>()V
invokevirtual Map/StringIntegerMap()Ljava/util/HashMap;
putstatic SampleProgram2/occurrences Ljava/util/HashMap;
    ldc 0
    putstatic SampleProgram2/i I
L10:
    getstatic SampleProgram2/i I
    getstatic SampleProgram2/size I
    if_icmplt L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifne L005
    goto L006
L005:
aload_0
    getstatic SampleProgram2/i I
invokevirtual List/getValString(I)Ljava/lang/String;
    putstatic SampleProgram2/temp Ljava/lang/String;
aload_3
    getstatic SampleProgram2/temp Ljava/lang/String;
invokevirtual Map/contains(Ljava/lang/String;)Z
    putstatic SampleProgram2/test Z
    getstatic SampleProgram2/test Z
    ifeq L0026
aload_3
    getstatic SampleProgram2/temp Ljava/lang/String;
invokevirtual Map/getValStringInteger(Ljava/lang/String;)I
    putstatic SampleProgram2/currentOccurrence I
aload_3
    getstatic SampleProgram2/temp Ljava/lang/String;
    getstatic SampleProgram2/currentOccurrence I
    ldc 1
    iadd
invokevirtual Map/addStringInteger(Ljava/lang/String;I)V
    goto L00100
L0026:
    iconst_1
    ifeq L0027
aload_3
    getstatic SampleProgram2/temp Ljava/lang/String;
    ldc 1
invokevirtual Map/addStringInteger(Ljava/lang/String;I)V
L0027:
L00100:
    getstatic SampleProgram2/i I
    ldc 1
    iadd
    putstatic SampleProgram2/i I
    goto L10
L006:
aload_3
invokevirtual Map/getString()Ljava/lang/String;
    putstatic SampleProgram2/desc Ljava/lang/String;
    ldc "HashMap "
    getstatic SampleProgram2/desc Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "HashMap "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic SampleProgram2/desc Ljava/lang/String;
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
    putstatic	SampleProgram2/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	SampleProgram2/_standardIn LPascalTextIn;

 new SampleProgram2
    dup
    invokespecial SampleProgram2/<init>()V
    invokevirtual SampleProgram2/main()V

    getstatic	SampleProgram2/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
