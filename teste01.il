.assembly extern mscorlib {}
.assembly _codigo_objeto{}
.module _codigo_objeto.exe

.class public _codigo_objeto{
.method static public void _principal(){
.entrypoint
ldc.i4.1
call void [mscorlib]System.Console::Write(bool)
ldc.i8 1
conv.r8
conv.i8
call void [mscorlib]System.Console::Write(int64)
ret
}
}