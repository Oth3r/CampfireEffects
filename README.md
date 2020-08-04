# CampfireEffects

Get potion effects while near campfires.\
Fully customizable via config.

## Config
config-version: \
  *Shows current config version, do not edit.*

check-ticks: 20\
    *Set how many ticks between each check for a campfire*

#### campfire:
effect: regeneration\
level: 1\
radius: 10

#### soul-campfire:
effect: resistance\
level: 1\
radius: 6

### Campfire info:
#### effect:
Set the potion effect the player will get when standing near a campfire.\
All effect names:\
*speed, slowness, haste, mining_fatigue, strength, instant_health, instant_damage, 
jump_boost, nausea, regeneration, resistance, fire_resistance, water_breathing, 
invisibility, blindness, night_vision, hunger, weakness, poison, wither, health_boost, 
absorption, saturation, glowing, levitation, luck, unluck, slow_falling, conduit_power, 
dolphins_grace, bad_omen, hero_of_the_village*

#### level:
Set the potion effect level.\
*Level is not the same as effect amplifier.\
1 level = 1 effect level.*

#### radius:
Set the radius for getting the effect. *(In blocks)*
