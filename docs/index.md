# Info
WoahMod is a Minecraft modification.  
It has many features such as spammer and mass message!
# Features
- /woahmod  
Main WoahMod command. Shows commands and version info. 
Usage: `/woahmod [commands]`  
Example: `/woahmod`
- /massmsg  
Run a command once for every player on the server.  
Replaces `%player%` as the current player in the loop.  
Usage: `/massmsg <delay in ms> <command>`  
Example: `/massmsg 300 /msg %player% hello!`  
- /spammer  
Spams a command x amount of times with a delay.  
Usage: `/spammer <delay in ms> <amount> <command>`  
Example: `/spammer 1000 10 /tell hpf hello!`
- /spammer file  
Spams commands from a file located in `.minecraft/mods/woahmod/spammerfiles/`  
`-p`: Replaces `%p%` in the file with the argument following `-p`  
Usage: `/spammer file <delay in ms> <file> [-p <text>]`  
Example: `/spammer file 100 allstarmsg.txt -p hpf`
- Tags  
Tags are things that appear before your name above your head.  
You may request one on the [Discord server](https://discord.gg/a2DQmak)!

# Downloading
- Grab a build from the [releases](/releases) page
- Install [Minecraft Forge for 1.8.9](https://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.8.9.html)
- Put the release you downloaded in your `.minecraft/mods/` directory.
- Launch the game with forge.
- Done!

# .minecraft location
- Windows: `%appdata%\.minecraft\`
- Mac: `~/Library/Application Support/minecraft/`
- Linux: `~/.minecraft/`
