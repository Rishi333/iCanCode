.class public BubbleSort
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a Ljava/util/ArrayList;
.field private static i I
.field private static j I
.field private static k I
.field private static size I
.field private static swapVal I
.field private static swappedThisTime Z
.field private static temp1 I
.field private static temp2 I
.field private static tempVal I
.field private static w I

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
putstatic BubbleSort/a Ljava/util/ArrayList;
aload_0
    ldc 1
invokevirtual List/add(I)V
aload_0
    ldc 2
invokevirtual List/add(I)V
aload_0
    ldc 6
invokevirtual List/add(I)V
aload_0
    ldc 4
invokevirtual List/add(I)V
aload_0
    ldc 3
invokevirtual List/add(I)V
aload_0
    ldc 9
invokevirtual List/add(I)V
aload_0
    ldc 5
invokevirtual List/add(I)V
aload_0
    ldc 7
invokevirtual List/add(I)V
aload_0
    ldc 8
invokevirtual List/add(I)V
    ldc 1
    putstatic BubbleSort/swappedThisTime Z
aload_0
    ldc 0
invokevirtual List/getValInteger(I)I
    putstatic BubbleSort/swapVal I
aload_0
invokevirtual List/getSize()I
    putstatic BubbleSort/size I
    ldc "Printing unsorted order"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Printing unsorted order"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc 0
    putstatic BubbleSort/k I
L10:
    getstatic BubbleSort/k I
    getstatic BubbleSort/size I
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
    getstatic BubbleSort/k I
invokevirtual List/getValInteger(I)I
    putstatic BubbleSort/tempVal I
    ldc " "
    getstatic BubbleSort/tempVal I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc " "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic BubbleSort/tempVal I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    getstatic BubbleSort/k I
    ldc 1
    iadd
    putstatic BubbleSort/k I
    goto L10
L006:
    ldc ""

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc ""
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc ""

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc ""
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc 0
    putstatic BubbleSort/i I
L20:
    getstatic BubbleSort/i I
    getstatic BubbleSort/size I
    ldc 1
    isub
    if_icmplt L0025
    iconst_0
    goto L0026
L0025:
    iconst_1
L0026:
    ifne L0027
    goto L0028
L0027:
    ldc 0
    putstatic BubbleSort/j I
L30:
    getstatic BubbleSort/j I
    getstatic BubbleSort/size I
    ldc 1
    isub
    if_icmplt L0047
    iconst_0
    goto L0048
L0047:
    iconst_1
L0048:
    ifne L0049
    goto L0050
L0049:
    ldc 0
    putstatic BubbleSort/swappedThisTime Z
aload_0
    getstatic BubbleSort/j I
invokevirtual List/getValInteger(I)I
    putstatic BubbleSort/temp1 I
aload_0
    getstatic BubbleSort/j I
    ldc 1
    iadd
invokevirtual List/getValInteger(I)I
    putstatic BubbleSort/temp2 I
    getstatic BubbleSort/temp1 I
    getstatic BubbleSort/temp2 I
    if_icmpgt L0069
    iconst_0
    goto L0070
L0069:
    iconst_1
L0070:
    ifeq L0072
    getstatic BubbleSort/temp1 I
    putstatic BubbleSort/swapVal I
aload_0
    getstatic BubbleSort/j I
    getstatic BubbleSort/temp2 I
invokevirtual List/setVal(II)V
aload_0
    getstatic BubbleSort/j I
    ldc 1
    iadd
    getstatic BubbleSort/swapVal I
invokevirtual List/setVal(II)V
    ldc 1
    putstatic BubbleSort/swappedThisTime Z
    goto L00100
L0072:
L00100:
    getstatic BubbleSort/j I
    ldc 1
    iadd
    putstatic BubbleSort/j I
    goto L30
L0050:
    getstatic BubbleSort/swappedThisTime Z
    ldc 0
    if_icmpeq L0074
    iconst_0
    goto L0075
L0074:
    iconst_1
L0075:
    ifeq L0077
    getstatic BubbleSort/size I
    ldc 2
    iadd
    putstatic BubbleSort/i I
    goto L00101
L0077:
L00101:
    getstatic BubbleSort/i I
    ldc 1
    iadd
    putstatic BubbleSort/i I
    goto L20
L0028:
    ldc "Printing sorted order"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Printing sorted order"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc 0
    putstatic BubbleSort/w I
L40:
    getstatic BubbleSort/w I
    getstatic BubbleSort/size I
    if_icmplt L0079
    iconst_0
    goto L0080
L0079:
    iconst_1
L0080:
    ifne L0081
    goto L0082
L0081:
aload_0
    getstatic BubbleSort/w I
invokevirtual List/getValInteger(I)I
    putstatic BubbleSort/tempVal I
    ldc " "
    getstatic BubbleSort/tempVal I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc " "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic BubbleSort/tempVal I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    getstatic BubbleSort/w I
    ldc 1
    iadd
    putstatic BubbleSort/w I
    goto L40
L0082:

return
.limit locals 32
.limit stack 40
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	BubbleSort/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	BubbleSort/_standardIn LPascalTextIn;

 new BubbleSort
    dup
    invokespecial BubbleSort/<init>()V
    invokevirtual BubbleSort/main()V

    getstatic	BubbleSort/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
