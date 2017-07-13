/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9987
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		System.out.println(get(new Scanner(System.in).nextInt()));
	}

	private static String get(int index) {
		switch (index) {
		case 1:
			return "Bulbasaur\nGrass Poison";
		case 2:
			return "Ivysaur\nGrass Poison";
		case 3:
			return "Venusaur\nGrass Poison";
		case 4:
			return "Charmander\nFire";
		case 5:
			return "Charmeleon\nFire";
		case 6:
			return "Charizard\nFire Flying";
		case 7:
			return "Squirtle\nWater";
		case 8:
			return "Wartortle\nWater";
		case 9:
			return "Blastoise\nWater";
		case 10:
			return "Caterpie\nBug";
		case 11:
			return "Metapod\nBug";
		case 12:
			return "Butterfree\nBug Flying";
		case 13:
			return "Weedle\nBug Poison";
		case 14:
			return "Kakuna\nBug Poison";
		case 15:
			return "Beedrill\nBug Poison";
		case 16:
			return "Pidgey\nNormal Flying";
		case 17:
			return "Pidgeotto\nNormal Flying";
		case 18:
			return "Pidgeot\nNormal Flying";
		case 19:
			return "Rattata\nNormal";
		case 20:
			return "Raticate\nNormal";
		case 21:
			return "Spearow\nNormal Flying";
		case 22:
			return "Fearow\nNormal Flying";
		case 23:
			return "Ekans\nPoison";
		case 24:
			return "Arbok\nPoison";
		case 25:
			return "Pikachu\nElectric";
		case 26:
			return "Raichu\nElectric";
		case 27:
			return "Sandshrew\nGround";
		case 28:
			return "Sandslash\nGround";
		case 29:
			return "Nidoran♀\nPoison";
		case 30:
			return "Nidorina\nPoison";
		case 31:
			return "Nidoqueen\nPoison Ground";
		case 32:
			return "Nidoran♂\nPoison";
		case 33:
			return "Nidorino\nPoison";
		case 34:
			return "Nidoking\nPoison Ground";
		case 35:
			return "Clefairy\nFairy";
		case 36:
			return "Clefable\nFairy";
		case 37:
			return "Vulpix\nFire";
		case 38:
			return "Ninetales\nFire";
		case 39:
			return "Jigglypuff\nNormal Fairy";
		case 40:
			return "Wigglytuff\nNormal Fairy";
		case 41:
			return "Zubat\nPoison Flying";
		case 42:
			return "Golbat\nPoison Flying";
		case 43:
			return "Oddish\nGrass Poison";
		case 44:
			return "Gloom\nGrass Poison";
		case 45:
			return "Vileplume\nGrass Poison";
		case 46:
			return "Paras\nBug Grass";
		case 47:
			return "Parasect\nBug Grass";
		case 48:
			return "Venonat\nBug Poison";
		case 49:
			return "Venomoth\nBug Poison";
		case 50:
			return "Diglett\nGround";
		case 51:
			return "Dugtrio\nGround";
		case 52:
			return "Meowth\nNormal";
		case 53:
			return "Persian\nNormal";
		case 54:
			return "Psyduck\nWater";
		case 55:
			return "Golduck\nWater";
		case 56:
			return "Mankey\nFighting";
		case 57:
			return "Primeape\nFighting";
		case 58:
			return "Growlithe\nFire";
		case 59:
			return "Arcanine\nFire";
		case 60:
			return "Poliwag\nWater";
		case 61:
			return "Poliwhirl\nWater";
		case 62:
			return "Poliwrath\nWater Fighting";
		case 63:
			return "Abra\nPsychic";
		case 64:
			return "Kadabra\nPsychic";
		case 65:
			return "Alakazam\nPsychic";
		case 66:
			return "Machop\nFighting";
		case 67:
			return "Machoke\nFighting";
		case 68:
			return "Machamp\nFighting";
		case 69:
			return "Bellsprout\nGrass Poison";
		case 70:
			return "Weepinbell\nGrass Poison";
		case 71:
			return "Victreebel\nGrass Poison";
		case 72:
			return "Tentacool\nWater Poison";
		case 73:
			return "Tentacruel\nWater Poison";
		case 74:
			return "Geodude\nRock Ground";
		case 75:
			return "Graveler\nRock Ground";
		case 76:
			return "Golem\nRock Ground";
		case 77:
			return "Ponyta\nFire";
		case 78:
			return "Rapidash\nFire";
		case 79:
			return "Slowpoke\nWater Psychic";
		case 80:
			return "Slowbro\nWater Psychic";
		case 81:
			return "Magnemite\nElectric Steel";
		case 82:
			return "Magneton\nElectric Steel";
		case 83:
			return "Farfetch'd\nNormal Flying";
		case 84:
			return "Doduo\nNormal Flying";
		case 85:
			return "Dodrio\nNormal Flying";
		case 86:
			return "Seel\nWater";
		case 87:
			return "Dewgong\nWater Ice";
		case 88:
			return "Grimer\nPoison";
		case 89:
			return "Muk\nPoison";
		case 90:
			return "Shellder\nWater";
		case 91:
			return "Cloyster\nWater Ice";
		case 92:
			return "Gastly\nGhost Poison";
		case 93:
			return "Haunter\nGhost Poison";
		case 94:
			return "Gengar\nGhost Poison";
		case 95:
			return "Onix\nRock Ground";
		case 96:
			return "Drowzee\nPsychic";
		case 97:
			return "Hypno\nPsychic";
		case 98:
			return "Krabby\nWater";
		case 99:
			return "Kingler\nWater";
		case 100:
			return "Voltorb\nElectric";
		case 101:
			return "Electrode\nElectric";
		case 102:
			return "Exeggcute\nGrass Psychic";
		case 103:
			return "Exeggutor\nGrass Psychic";
		case 104:
			return "Cubone\nGround";
		case 105:
			return "Marowak\nGround";
		case 106:
			return "Hitmonlee\nFighting";
		case 107:
			return "Hitmonchan\nFighting";
		case 108:
			return "Lickitung\nNormal";
		case 109:
			return "Koffing\nPoison";
		case 110:
			return "Weezing\nPoison";
		case 111:
			return "Rhyhorn\nGround Rock";
		case 112:
			return "Rhydon\nGround Rock";
		case 113:
			return "Chansey\nNormal";
		case 114:
			return "Tangela\nGrass";
		case 115:
			return "Kangaskhan\nNormal";
		case 116:
			return "Horsea\nWater";
		case 117:
			return "Seadra\nWater";
		case 118:
			return "Goldeen\nWater";
		case 119:
			return "Seaking\nWater";
		case 120:
			return "Staryu\nWater";
		case 121:
			return "Starmie\nWater Psychic";
		case 122:
			return "Mr. Mime\nPsychic Fairy";
		case 123:
			return "Scyther\nBug Flying";
		case 124:
			return "Jynx\nIce Psychic";
		case 125:
			return "Electabuzz\nElectric";
		case 126:
			return "Magmar\nFire";
		case 127:
			return "Pinsir\nBug";
		case 128:
			return "Tauros\nNormal";
		case 129:
			return "Magikarp\nWater";
		case 130:
			return "Gyarados\nWater Flying";
		case 131:
			return "Lapras\nWater Ice";
		case 132:
			return "Ditto\nNormal";
		case 133:
			return "Eevee\nNormal";
		case 134:
			return "Vaporeon\nWater";
		case 135:
			return "Jolteon\nElectric";
		case 136:
			return "Flareon\nFire";
		case 137:
			return "Porygon\nNormal";
		case 138:
			return "Omanyte\nRock Water";
		case 139:
			return "Omastar\nRock Water";
		case 140:
			return "Kabuto\nRock Water";
		case 141:
			return "Kabutops\nRock Water";
		case 142:
			return "Aerodactyl\nRock Flying";
		case 143:
			return "Snorlax\nNormal";
		case 144:
			return "Articuno\nIce Flying";
		case 145:
			return "Zapdos\nElectric Flying";
		case 146:
			return "Moltres\nFire Flying";
		case 147:
			return "Dratini\nDragon";
		case 148:
			return "Dragonair\nDragon";
		case 149:
			return "Dragonite\nDragon Flying";
		case 150:
			return "Mewtwo\nPsychic";
		case 151:
			return "Mew\nPsychic";
		case 152:
			return "Chikorita\nGrass";
		case 153:
			return "Bayleef\nGrass";
		case 154:
			return "Meganium\nGrass";
		case 155:
			return "Cyndaquil\nFire";
		case 156:
			return "Quilava\nFire";
		case 157:
			return "Typhlosion\nFire";
		case 158:
			return "Totodile\nWater";
		case 159:
			return "Croconaw\nWater";
		case 160:
			return "Feraligatr\nWater";
		case 161:
			return "Sentret\nNormal";
		case 162:
			return "Furret\nNormal";
		case 163:
			return "Hoothoot\nNormal Flying";
		case 164:
			return "Noctowl\nNormal Flying";
		case 165:
			return "Ledyba\nBug Flying";
		case 166:
			return "Ledian\nBug Flying";
		case 167:
			return "Spinarak\nBug Poison";
		case 168:
			return "Ariados\nBug Poison";
		case 169:
			return "Crobat\nPoison Flying";
		case 170:
			return "Chinchou\nWater Electric";
		case 171:
			return "Lanturn\nWater Electric";
		case 172:
			return "Pichu\nElectric";
		case 173:
			return "Cleffa\nFairy";
		case 174:
			return "Igglybuff\nNormal Fairy";
		case 175:
			return "Togepi\nFairy";
		case 176:
			return "Togetic\nFairy Flying";
		case 177:
			return "Natu\nPsychic Flying";
		case 178:
			return "Xatu\nPsychic Flying";
		case 179:
			return "Mareep\nElectric";
		case 180:
			return "Flaaffy\nElectric";
		case 181:
			return "Ampharos\nElectric";
		case 182:
			return "Bellossom\nGrass";
		case 183:
			return "Marill\nWater Fairy";
		case 184:
			return "Azumarill\nWater Fairy";
		case 185:
			return "Sudowoodo\nRock";
		case 186:
			return "Politoed\nWater";
		case 187:
			return "Hoppip\nGrass Flying";
		case 188:
			return "Skiploom\nGrass Flying";
		case 189:
			return "Jumpluff\nGrass Flying";
		case 190:
			return "Aipom\nNormal";
		case 191:
			return "Sunkern\nGrass";
		case 192:
			return "Sunflora\nGrass";
		case 193:
			return "Yanma\nBug Flying";
		case 194:
			return "Wooper\nWater Ground";
		case 195:
			return "Quagsire\nWater Ground";
		case 196:
			return "Espeon\nPsychic";
		case 197:
			return "Umbreon\nDark";
		case 198:
			return "Murkrow\nDark Flying";
		case 199:
			return "Slowking\nWater Psychic";
		case 200:
			return "Misdreavus\nGhost";
		case 201:
			return "Unown\nPsychic";
		case 202:
			return "Wobbuffet\nPsychic";
		case 203:
			return "Girafarig\nNormal Psychic";
		case 204:
			return "Pineco\nBug";
		case 205:
			return "Forretress\nBug Steel";
		case 206:
			return "Dunsparce\nNormal";
		case 207:
			return "Gligar\nGround Flying";
		case 208:
			return "Steelix\nSteel Ground";
		case 209:
			return "Snubbull\nFairy";
		case 210:
			return "Granbull\nFairy";
		case 211:
			return "Qwilfish\nWater Poison";
		case 212:
			return "Scizor\nBug Steel";
		case 213:
			return "Shuckle\nBug Rock";
		case 214:
			return "Heracross\nBug Fighting";
		case 215:
			return "Sneasel\nDark Ice";
		case 216:
			return "Teddiursa\nNormal";
		case 217:
			return "Ursaring\nNormal";
		case 218:
			return "Slugma\nFire";
		case 219:
			return "Magcargo\nFire Rock";
		case 220:
			return "Swinub\nIce Ground";
		case 221:
			return "Piloswine\nIce Ground";
		case 222:
			return "Corsola\nWater Rock";
		case 223:
			return "Remoraid\nWater";
		case 224:
			return "Octillery\nWater";
		case 225:
			return "Delibird\nIce Flying";
		case 226:
			return "Mantine\nWater Flying";
		case 227:
			return "Skarmory\nSteel Flying";
		case 228:
			return "Houndour\nDark Fire";
		case 229:
			return "Houndoom\nDark Fire";
		case 230:
			return "Kingdra\nWater Dragon";
		case 231:
			return "Phanpy\nGround";
		case 232:
			return "Donphan\nGround";
		case 233:
			return "Porygon2\nNormal";
		case 234:
			return "Stantler\nNormal";
		case 235:
			return "Smeargle\nNormal";
		case 236:
			return "Tyrogue\nFighting";
		case 237:
			return "Hitmontop\nFighting";
		case 238:
			return "Smoochum\nIce Psychic";
		case 239:
			return "Elekid\nElectric";
		case 240:
			return "Magby\nFire";
		case 241:
			return "Miltank\nNormal";
		case 242:
			return "Blissey\nNormal";
		case 243:
			return "Raikou\nElectric";
		case 244:
			return "Entei\nFire";
		case 245:
			return "Suicune\nWater";
		case 246:
			return "Larvitar\nRock Ground";
		case 247:
			return "Pupitar\nRock Ground";
		case 248:
			return "Tyranitar\nRock Dark";
		case 249:
			return "Lugia\nPsychic Flying";
		case 250:
			return "Ho-oh\nFire Flying";
		case 251:
			return "Celebi\nPsychic Grass";
		case 252:
			return "Treecko\nGrass";
		case 253:
			return "Grovyle\nGrass";
		case 254:
			return "Sceptile\nGrass";
		case 255:
			return "Torchic\nFire";
		case 256:
			return "Combusken\nFire Fighting";
		case 257:
			return "Blaziken\nFire Fighting";
		case 258:
			return "Mudkip\nWater";
		case 259:
			return "Marshtomp\nWater Ground";
		case 260:
			return "Swampert\nWater Ground";
		case 261:
			return "Poochyena\nDark";
		case 262:
			return "Mightyena\nDark";
		case 263:
			return "Zigzagoon\nNormal";
		case 264:
			return "Linoone\nNormal";
		case 265:
			return "Wurmple\nBug";
		case 266:
			return "Silcoon\nBug";
		case 267:
			return "Beautifly\nBug Flying";
		case 268:
			return "Cascoon\nBug";
		case 269:
			return "Dustox\nBug Poison";
		case 270:
			return "Lotad\nWater Grass";
		case 271:
			return "Lombre\nWater Grass";
		case 272:
			return "Ludicolo\nWater Grass";
		case 273:
			return "Seedot\nGrass";
		case 274:
			return "Nuzleaf\nGrass Dark";
		case 275:
			return "Shiftry\nGrass Dark";
		case 276:
			return "Taillow\nNormal Flying";
		case 277:
			return "Swellow\nNormal Flying";
		case 278:
			return "Wingull\nWater Flying";
		case 279:
			return "Pelipper\nWater Flying";
		case 280:
			return "Ralts\nPsychic Fairy";
		case 281:
			return "Kirlia\nPsychic Fairy";
		case 282:
			return "Gardevoir\nPsychic Fairy";
		case 283:
			return "Surskit\nBug Water";
		case 284:
			return "Masquerain\nBug Flying";
		case 285:
			return "Shroomish\nGrass";
		case 286:
			return "Breloom\nGrass Fighting";
		case 287:
			return "Slakoth\nNormal";
		case 288:
			return "Vigoroth\nNormal";
		case 289:
			return "Slaking\nNormal";
		case 290:
			return "Nincada\nBug Ground";
		case 291:
			return "Ninjask\nBug Flying";
		case 292:
			return "Shedinja\nBug Ghost";
		case 293:
			return "Whismur\nNormal";
		case 294:
			return "Loudred\nNormal";
		case 295:
			return "Exploud\nNormal";
		case 296:
			return "Makuhita\nFighting";
		case 297:
			return "Hariyama\nFighting";
		case 298:
			return "Azurill\nNormal Fairy";
		case 299:
			return "Nosepass\nRock";
		case 300:
			return "Skitty\nNormal";
		case 301:
			return "Delcatty\nNormal";
		case 302:
			return "Sableye\nDark Ghost";
		case 303:
			return "Mawile\nSteel Fairy";
		case 304:
			return "Aron\nSteel Rock";
		case 305:
			return "Lairon\nSteel Rock";
		case 306:
			return "Aggron\nSteel Rock";
		case 307:
			return "Meditite\nFighting Psychic";
		case 308:
			return "Medicham\nFighting Psychic";
		case 309:
			return "Electrike\nElectric";
		case 310:
			return "Manectric\nElectric";
		case 311:
			return "Plusle\nElectric";
		case 312:
			return "Minun\nElectric";
		case 313:
			return "Volbeat\nBug";
		case 314:
			return "Illumise\nBug";
		case 315:
			return "Roselia\nGrass Poison";
		case 316:
			return "Gulpin\nPoison";
		case 317:
			return "Swalot\nPoison";
		case 318:
			return "Carvanha\nWater Dark";
		case 319:
			return "Sharpedo\nWater Dark";
		case 320:
			return "Wailmer\nWater";
		case 321:
			return "Wailord\nWater";
		case 322:
			return "Numel\nFire Ground";
		case 323:
			return "Camerupt\nFire Ground";
		case 324:
			return "Torkoal\nFire";
		case 325:
			return "Spoink\nPsychic";
		case 326:
			return "Grumpig\nPsychic";
		case 327:
			return "Spinda\nNormal";
		case 328:
			return "Trapinch\nGround";
		case 329:
			return "Vibrava\nGround Dragon";
		case 330:
			return "Flygon\nGround Dragon";
		case 331:
			return "Cacnea\nGrass";
		case 332:
			return "Cacturne\nGrass Dark";
		case 333:
			return "Swablu\nNormal Flying";
		case 334:
			return "Altaria\nDragon Flying";
		case 335:
			return "Zangoose\nNormal";
		case 336:
			return "Seviper\nPoison";
		case 337:
			return "Lunatone\nRock Psychic";
		case 338:
			return "Solrock\nRock Psychic";
		case 339:
			return "Barboach\nWater Ground";
		case 340:
			return "Whiscash\nWater Ground";
		case 341:
			return "Corphish\nWater";
		case 342:
			return "Crawdaunt\nWater Dark";
		case 343:
			return "Baltoy\nGround Psychic";
		case 344:
			return "Claydol\nGround Psychic";
		case 345:
			return "Lileep\nRock Grass";
		case 346:
			return "Cradily\nRock Grass";
		case 347:
			return "Anorith\nRock Bug";
		case 348:
			return "Armaldo\nRock Bug";
		case 349:
			return "Feebas\nWater";
		case 350:
			return "Milotic\nWater";
		case 351:
			return "Castform\nNormal";
		case 352:
			return "Kecleon\nNormal";
		case 353:
			return "Shuppet\nGhost";
		case 354:
			return "Banette\nGhost";
		case 355:
			return "Duskull\nGhost";
		case 356:
			return "Dusclops\nGhost";
		case 357:
			return "Tropius\nGrass Flying";
		case 358:
			return "Chimecho\nPsychic";
		case 359:
			return "Absol\nDark";
		case 360:
			return "Wynaut\nPsychic";
		case 361:
			return "Snorunt\nIce";
		case 362:
			return "Glalie\nIce";
		case 363:
			return "Spheal\nIce Water";
		case 364:
			return "Sealeo\nIce Water";
		case 365:
			return "Walrein\nIce Water";
		case 366:
			return "Clamperl\nWater";
		case 367:
			return "Huntail\nWater";
		case 368:
			return "Gorebyss\nWater";
		case 369:
			return "Relicanth\nWater Rock";
		case 370:
			return "Luvdisc\nWater";
		case 371:
			return "Bagon\nDragon";
		case 372:
			return "Shelgon\nDragon";
		case 373:
			return "Salamence\nDragon Flying";
		case 374:
			return "Beldum\nSteel Psychic";
		case 375:
			return "Metang\nSteel Psychic";
		case 376:
			return "Metagross\nSteel Psychic";
		case 377:
			return "Regirock\nRock";
		case 378:
			return "Regice\nIce";
		case 379:
			return "Registeel\nSteel";
		case 380:
			return "Latias\nDragon Psychic";
		case 381:
			return "Latios\nDragon Psychic";
		case 382:
			return "Kyogre\nWater";
		case 383:
			return "Groudon\nGround";
		case 384:
			return "Rayquaza\nDragon Flying";
		case 385:
			return "Jirachi\nSteel Psychic";
		case 386:
			return "Deoxys\nPsychic";
		case 387:
			return "Turtwig\nGrass";
		case 388:
			return "Grotle\nGrass";
		case 389:
			return "Torterra\nGrass Ground";
		case 390:
			return "Chimchar\nFire";
		case 391:
			return "Monferno\nFire Fighting";
		case 392:
			return "Infernape\nFire Fighting";
		case 393:
			return "Piplup\nWater";
		case 394:
			return "Prinplup\nWater";
		case 395:
			return "Empoleon\nWater Steel";
		case 396:
			return "Starly\nNormal Flying";
		case 397:
			return "Staravia\nNormal Flying";
		case 398:
			return "Staraptor\nNormal Flying";
		case 399:
			return "Bidoof\nNormal";
		case 400:
			return "Bibarel\nNormal Water";
		case 401:
			return "Kricketot\nBug";
		case 402:
			return "Kricketune\nBug";
		case 403:
			return "Shinx\nElectric";
		case 404:
			return "Luxio\nElectric";
		case 405:
			return "Luxray\nElectric";
		case 406:
			return "Budew\nGrass Poison";
		case 407:
			return "Roserade\nGrass Poison";
		case 408:
			return "Cranidos\nRock";
		case 409:
			return "Rampardos\nRock";
		case 410:
			return "Shieldon\nRock Steel";
		case 411:
			return "Bastiodon\nRock Steel";
		case 412:
			return "Burmy\nBug";
		case 413:
			return "Wormadam\nBug Grass";
		case 414:
			return "Mothim\nBug Flying";
		case 415:
			return "Combee\nBug Flying";
		case 416:
			return "Vespiquen\nBug Flying";
		case 417:
			return "Pachirisu\nElectric";
		case 418:
			return "Buizel\nWater";
		case 419:
			return "Floatzel\nWater";
		case 420:
			return "Cherubi\nGrass";
		case 421:
			return "Cherrim\nGrass";
		case 422:
			return "Shellos\nWater";
		case 423:
			return "Gastrodon\nWater Ground";
		case 424:
			return "Ambipom\nNormal";
		case 425:
			return "Drifloon\nGhost Flying";
		case 426:
			return "Drifblim\nGhost Flying";
		case 427:
			return "Buneary\nNormal";
		case 428:
			return "Lopunny\nNormal";
		case 429:
			return "Mismagius\nGhost";
		case 430:
			return "Honchkrow\nDark Flying";
		case 431:
			return "Glameow\nNormal";
		case 432:
			return "Purugly\nNormal";
		case 433:
			return "Chingling\nPsychic";
		case 434:
			return "Stunky\nPoison Dark";
		case 435:
			return "Skuntank\nPoison Dark";
		case 436:
			return "Bronzor\nSteel Psychic";
		case 437:
			return "Bronzong\nSteel Psychic";
		case 438:
			return "Bonsly\nRock";
		case 439:
			return "Mime Jr.\nPsychic Fairy";
		case 440:
			return "Happiny\nNormal";
		case 441:
			return "Chatot\nNormal Flying";
		case 442:
			return "Spiritomb\nGhost Dark";
		case 443:
			return "Gible\nDragon Ground";
		case 444:
			return "Gabite\nDragon Ground";
		case 445:
			return "Garchomp\nDragon Ground";
		case 446:
			return "Munchlax\nNormal";
		case 447:
			return "Riolu\nFighting";
		case 448:
			return "Lucario\nFighting Steel";
		case 449:
			return "Hippopotas\nGround";
		case 450:
			return "Hippowdon\nGround";
		case 451:
			return "Skorupi\nPoison Bug";
		case 452:
			return "Drapion\nPoison Dark";
		case 453:
			return "Croagunk\nPoison Fighting";
		case 454:
			return "Toxicroak\nPoison Fighting";
		case 455:
			return "Carnivine\nGrass";
		case 456:
			return "Finneon\nWater";
		case 457:
			return "Lumineon\nWater";
		case 458:
			return "Mantyke\nWater Flying";
		case 459:
			return "Snover\nGrass Ice";
		case 460:
			return "Abomasnow\nGrass Ice";
		case 461:
			return "Weavile\nDark Ice";
		case 462:
			return "Magnezone\nElectric Steel";
		case 463:
			return "Lickilicky\nNormal";
		case 464:
			return "Rhyperior\nGround Rock";
		case 465:
			return "Tangrowth\nGrass";
		case 466:
			return "Electivire\nElectric";
		case 467:
			return "Magmortar\nFire";
		case 468:
			return "Togekiss\nFairy Flying";
		case 469:
			return "Yanmega\nBug Flying";
		case 470:
			return "Leafeon\nGrass";
		case 471:
			return "Glaceon\nIce";
		case 472:
			return "Gliscor\nGround Flying";
		case 473:
			return "Mamoswine\nIce Ground";
		case 474:
			return "Porygon-Z\nNormal";
		case 475:
			return "Gallade\nPsychic Fighting";
		case 476:
			return "Probopass\nRock Steel";
		case 477:
			return "Dusknoir\nGhost";
		case 478:
			return "Froslass\nIce Ghost";
		case 479:
			return "Rotom\nElectric Ghost";
		case 480:
			return "Uxie\nPsychic";
		case 481:
			return "Mesprit\nPsychic";
		case 482:
			return "Azelf\nPsychic";
		case 483:
			return "Dialga\nSteel Dragon";
		case 484:
			return "Palkia\nWater Dragon";
		case 485:
			return "Heatran\nFire Steel";
		case 486:
			return "Regigigas\nNormal";
		case 487:
			return "Giratina\nGhost Dragon";
		case 488:
			return "Cresselia\nPsychic";
		case 489:
			return "Phione\nWater";
		case 490:
			return "Manaphy\nWater";
		case 491:
			return "Darkrai\nDark";
		case 492:
			return "Shaymin\nGrass";
		case 493:
			return "Arceus\nNormal";
		case 494:
			return "Victini\nPsychic Fire";
		case 495:
			return "Snivy\nGrass";
		case 496:
			return "Servine\nGrass";
		case 497:
			return "Serperior\nGrass";
		case 498:
			return "Tepig\nFire";
		case 499:
			return "Pignite\nFire Fighting";
		case 500:
			return "Emboar\nFire Fighting";
		case 501:
			return "Oshawott\nWater";
		case 502:
			return "Dewott\nWater";
		case 503:
			return "Samurott\nWater";
		case 504:
			return "Patrat\nNormal";
		case 505:
			return "Watchog\nNormal";
		case 506:
			return "Lillipup\nNormal";
		case 507:
			return "Herdier\nNormal";
		case 508:
			return "Stoutland\nNormal";
		case 509:
			return "Purrloin\nDark";
		case 510:
			return "Liepard\nDark";
		case 511:
			return "Pansage\nGrass";
		case 512:
			return "Simisage\nGrass";
		case 513:
			return "Pansear\nFire";
		case 514:
			return "Simisear\nFire";
		case 515:
			return "Panpour\nWater";
		case 516:
			return "Simipour\nWater";
		case 517:
			return "Munna\nPsychic";
		case 518:
			return "Musharna\nPsychic";
		case 519:
			return "Pidove\nNormal Flying";
		case 520:
			return "Tranquill\nNormal Flying";
		case 521:
			return "Unfezant\nNormal Flying";
		case 522:
			return "Blitzle\nElectric";
		case 523:
			return "Zebstrika\nElectric";
		case 524:
			return "Roggenrola\nRock";
		case 525:
			return "Boldore\nRock";
		case 526:
			return "Gigalith\nRock";
		case 527:
			return "Woobat\nPsychic Flying";
		case 528:
			return "Swoobat\nPsychic Flying";
		case 529:
			return "Drilbur\nGround";
		case 530:
			return "Excadrill\nGround Steel";
		case 531:
			return "Audino\nNormal";
		case 532:
			return "Timburr\nFighting";
		case 533:
			return "Gurdurr\nFighting";
		case 534:
			return "Conkeldurr\nFighting";
		case 535:
			return "Tympole\nWater";
		case 536:
			return "Palpitoad\nWater Ground";
		case 537:
			return "Seismitoad\nWater Ground";
		case 538:
			return "Throh\nFighting";
		case 539:
			return "Sawk\nFighting";
		case 540:
			return "Sewaddle\nBug Grass";
		case 541:
			return "Swadloon\nBug Grass";
		case 542:
			return "Leavanny\nBug Grass";
		case 543:
			return "Venipede\nBug Poison";
		case 544:
			return "Whirlipede\nBug Poison";
		case 545:
			return "Scolipede\nBug Poison";
		case 546:
			return "Cottonee\nGrass Fairy";
		case 547:
			return "Whimsicott\nGrass Fairy";
		case 548:
			return "Petilil\nGrass";
		case 549:
			return "Lilligant\nGrass";
		case 550:
			return "Basculin\nWater";
		case 551:
			return "Sandile\nGround Dark";
		case 552:
			return "Krokorok\nGround Dark";
		case 553:
			return "Krookodile\nGround Dark";
		case 554:
			return "Darumaka\nFire";
		case 555:
			return "Darmanitan\nFire";
		case 556:
			return "Maractus\nGrass";
		case 557:
			return "Dwebble\nBug Rock";
		case 558:
			return "Crustle\nBug Rock";
		case 559:
			return "Scraggy\nDark Fighting";
		case 560:
			return "Scrafty\nDark Fighting";
		case 561:
			return "Sigilyph\nPsychic Flying";
		case 562:
			return "Yamask\nGhost";
		case 563:
			return "Cofagrigus\nGhost";
		case 564:
			return "Tirtouga\nWater Rock";
		case 565:
			return "Carracosta\nWater Rock";
		case 566:
			return "Archen\nRock Flying";
		case 567:
			return "Archeops\nRock Flying";
		case 568:
			return "Trubbish\nPoison";
		case 569:
			return "Garbodor\nPoison";
		case 570:
			return "Zorua\nDark";
		case 571:
			return "Zoroark\nDark";
		case 572:
			return "Minccino\nNormal";
		case 573:
			return "Cinccino\nNormal";
		case 574:
			return "Gothita\nPsychic";
		case 575:
			return "Gothorita\nPsychic";
		case 576:
			return "Gothitelle\nPsychic";
		case 577:
			return "Solosis\nPsychic";
		case 578:
			return "Duosion\nPsychic";
		case 579:
			return "Reuniclus\nPsychic";
		case 580:
			return "Ducklett\nWater Flying";
		case 581:
			return "Swanna\nWater Flying";
		case 582:
			return "Vanillite\nIce";
		case 583:
			return "Vanillish\nIce";
		case 584:
			return "Vanilluxe\nIce";
		case 585:
			return "Deerling\nNormal Grass";
		case 586:
			return "Sawsbuck\nNormal Grass";
		case 587:
			return "Emolga\nElectric Flying";
		case 588:
			return "Karrablast\nBug";
		case 589:
			return "Escavalier\nBug Steel";
		case 590:
			return "Foongus\nGrass Poison";
		case 591:
			return "Amoonguss\nGrass Poison";
		case 592:
			return "Frillish\nWater Ghost";
		case 593:
			return "Jellicent\nWater Ghost";
		case 594:
			return "Alomomola\nWater";
		case 595:
			return "Joltik\nBug Electric";
		case 596:
			return "Galvantula\nBug Electric";
		case 597:
			return "Ferroseed\nGrass Steel";
		case 598:
			return "Ferrothorn\nGrass Steel";
		case 599:
			return "Klink\nSteel";
		case 600:
			return "Klang\nSteel";
		case 601:
			return "Klinklang\nSteel";
		case 602:
			return "Tynamo\nElectric";
		case 603:
			return "Eelektrik\nElectric";
		case 604:
			return "Eelektross\nElectric";
		case 605:
			return "Elgyem\nPsychic";
		case 606:
			return "Beheeyem\nPsychic";
		case 607:
			return "Litwick\nGhost Fire";
		case 608:
			return "Lampent\nGhost Fire";
		case 609:
			return "Chandelure\nGhost Fire";
		case 610:
			return "Axew\nDragon";
		case 611:
			return "Fraxure\nDragon";
		case 612:
			return "Haxorus\nDragon";
		case 613:
			return "Cubchoo\nIce";
		case 614:
			return "Beartic\nIce";
		case 615:
			return "Cryogonal\nIce";
		case 616:
			return "Shelmet\nBug";
		case 617:
			return "Accelgor\nBug";
		case 618:
			return "Stunfisk\nElectric Ground";
		case 619:
			return "Mienfoo\nFighting";
		case 620:
			return "Mienshao\nFighting";
		case 621:
			return "Druddigon\nDragon";
		case 622:
			return "Golett\nGround Ghost";
		case 623:
			return "Golurk\nGround Ghost";
		case 624:
			return "Pawniard\nDark Steel";
		case 625:
			return "Bisharp\nDark Steel";
		case 626:
			return "Bouffalant\nNormal";
		case 627:
			return "Rufflet\nNormal Flying";
		case 628:
			return "Braviary\nNormal Flying";
		case 629:
			return "Vullaby\nDark Flying";
		case 630:
			return "Mandibuzz\nDark Flying";
		case 631:
			return "Heatmor\nFire";
		case 632:
			return "Durant\nBug Steel";
		case 633:
			return "Deino\nDark Dragon";
		case 634:
			return "Zweilous\nDark Dragon";
		case 635:
			return "Hydreigon\nDark Dragon";
		case 636:
			return "Larvesta\nBug Fire";
		case 637:
			return "Volcarona\nBug Fire";
		case 638:
			return "Cobalion\nSteel Fighting";
		case 639:
			return "Terrakion\nRock Fighting";
		case 640:
			return "Virizion\nGrass Fighting";
		case 641:
			return "Tornadus\nFlying";
		case 642:
			return "Thundurus\nElectric Flying";
		case 643:
			return "Reshiram\nDragon Fire";
		case 644:
			return "Zekrom\nDragon Electric";
		case 645:
			return "Landorus\nGround Flying";
		case 646:
			return "Kyurem\nDragon Ice";
		case 647:
			return "Keldeo\nWater Fighting";
		case 648:
			return "Meloetta\nNormal Psychic";
		case 649:
			return "Genesect\nBug Steel";
		case 650:
			return "Chespin\nGrass";
		case 651:
			return "Quilladin\nGrass";
		case 652:
			return "Chesnaught\nGrass Fighting";
		case 653:
			return "Fennekin\nFire";
		case 654:
			return "Braixen\nFire";
		case 655:
			return "Delphox\nFire Psychic";
		case 656:
			return "Froakie\nWater";
		case 657:
			return "Frogadier\nWater";
		case 658:
			return "Greninja\nWater Dark";
		case 659:
			return "Bunnelby\nNormal";
		case 660:
			return "Diggersby\nNormal Ground";
		case 661:
			return "Fletchling\nNormal Flying";
		case 662:
			return "Fletchinder\nFire Flying";
		case 663:
			return "Talonflame\nFire Flying";
		case 664:
			return "Scatterbug\nBug";
		case 665:
			return "Spewpa\nBug";
		case 666:
			return "Vivillon\nBug Flying";
		case 667:
			return "Litleo\nFire Normal";
		case 668:
			return "Pyroar\nFire Normal";
		case 669:
			return "Flabébé\nFairy";
		case 670:
			return "Floette\nFairy";
		case 671:
			return "Florges\nFairy";
		case 672:
			return "Skiddo\nGrass";
		case 673:
			return "Gogoat\nGrass";
		case 674:
			return "Pancham\nFighting";
		case 675:
			return "Pangoro\nFighting Dark";
		case 676:
			return "Furfrou\nNormal";
		case 677:
			return "Espurr\nPsychic";
		case 678:
			return "Meowstic\nPsychic";
		case 679:
			return "Honedge\nSteel Ghost";
		case 680:
			return "Doublade\nSteel Ghost";
		case 681:
			return "Aegislash\nSteel Ghost";
		case 682:
			return "Spritzee\nFairy";
		case 683:
			return "Aromatisse\nFairy";
		case 684:
			return "Swirlix\nFairy";
		case 685:
			return "Slurpuff\nFairy";
		case 686:
			return "Inkay\nDark Psychic";
		case 687:
			return "Malamar\nDark Psychic";
		case 688:
			return "Binacle\nRock Water";
		case 689:
			return "Barbaracle\nRock Water";
		case 690:
			return "Skrelp\nPoison Water";
		case 691:
			return "Dragalge\nPoison Dragon";
		case 692:
			return "Clauncher\nWater";
		case 693:
			return "Clawitzer\nWater";
		case 694:
			return "Helioptile\nElectric Normal";
		case 695:
			return "Heliolisk\nElectric Normal";
		case 696:
			return "Tyrunt\nRock Dragon";
		case 697:
			return "Tyrantrum\nRock Dragon";
		case 698:
			return "Amaura\nRock Ice";
		case 699:
			return "Aurorus\nRock Ice";
		case 700:
			return "Sylveon\nFairy";
		case 701:
			return "Hawlucha\nFighting Flying";
		case 702:
			return "Dedenne\nElectric Fairy";
		case 703:
			return "Carbink\nRock Fairy";
		case 704:
			return "Goomy\nDragon";
		case 705:
			return "Sliggoo\nDragon";
		case 706:
			return "Goodra\nDragon";
		case 707:
			return "Klefki\nSteel Fairy";
		case 708:
			return "Phantump\nGhost Grass";
		case 709:
			return "Trevenant\nGhost Grass";
		case 710:
			return "Pumpkaboo\nGhost Grass";
		case 711:
			return "Gourgeist\nGhost Grass";
		case 712:
			return "Bergmite\nIce";
		case 713:
			return "Avalugg\nIce";
		case 714:
			return "Noibat\nFlying Dragon";
		case 715:
			return "Noivern\nFlying Dragon";
		case 716:
			return "Xerneas\nFairy";
		case 717:
			return "Yveltal\nDark Flying";
		case 718:
			return "Zygarde\nDragon Ground";
		default:
			return "";
		}
	}
}