IDE:

    IntelliJ IDEA 2020.3.2 (Community Edition)
    Build #IC-203.7148.57, built on January 26, 2021
    Runtime version: 11.0.9.1+11-b1145.77 amd64
    VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
    Linux 5.4.0-66-generic
    GC: ParNew, ConcurrentMarkSweep
    Memory: 1654M
    Cores: 4
    Non-Bundled Plugins: com.jetbrains.ChooseRuntime, org.jetbrains.kotlin
    Current Desktop: ubuntu:GNOME

Building the project fails with the following error:

    java.lang.AssertionError: Unbound symbols not allowed
    Unbound private symbol org.jetbrains.kotlin.ir.symbols.impl.IrClassSymbolImpl@4fbb89d5 (NON-PUBLIC API)
    at org.jetbrains.kotlin.ir.util.SymbolTableKt.noUnboundLeft(SymbolTable.kt:1119)
    at org.jetbrains.kotlin.psi2ir.Psi2IrTranslator.generateModuleFragment(Psi2IrTranslator.kt:89)
    at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.generateModule(JvmIrCodegenFactory.kt:106)
    at org.jetbrains.kotlin.codegen.KotlinCodegenFacade.compileCorrectFiles(KotlinCodegenFacade.java:35)
    at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.generate(KotlinToJVMBytecodeCompiler.kt:595)
    at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:211)
    at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli$default(KotlinToJVMBytecodeCompiler.kt:154)
    at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:169)
    at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:52)
    at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:88)
    at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:44)
    at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:98)
    at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:386)
    at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:110)
    at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileIncrementally(IncrementalCompilerRunner.kt:286)
    at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileImpl$rebuild(IncrementalCompilerRunner.kt:99)
    at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileImpl(IncrementalCompilerRunner.kt:114)
    at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compile(IncrementalCompilerRunner.kt:74)
    at org.jetbrains.kotlin.daemon.CompileServiceImplBase.execIncrementalCompiler(CompileServiceImpl.kt:607)
    at org.jetbrains.kotlin.daemon.CompileServiceImplBase.access$execIncrementalCompiler(CompileServiceImpl.kt:96)
    at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1659)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:566)
    at java.rmi/sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:359)
    at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:200)
    at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:197)
    at java.base/java.security.AccessController.doPrivileged(Native Method)
    at java.rmi/sun.rmi.transport.Transport.serviceCall(Transport.java:196)
    at java.rmi/sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:562)
    at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:796)
    at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:677)
    at java.base/java.security.AccessController.doPrivileged(Native Method)
    at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:676)
    at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
    at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
    at java.base/java.lang.Thread.run(Thread.java:834)
`