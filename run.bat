pushd "C:\Users\James\AppData\Roaming\.minecraft\mods"

del "*.jar"

popd

cd "build\libs"

xcopy /y "*.jar" "C:\Users\James\AppData\Roaming\.minecraft\mods"

start /d "M:\Documents\Curse\Minecraft\Install\" minecraft.exe

cd ../..