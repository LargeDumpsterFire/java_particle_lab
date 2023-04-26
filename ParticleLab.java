
/*  Jacob Cohen

 // try making objects of the arrays as in layers to try explosions 
 
 */
//TODO make a code to make metal lines
//TODO add fire interactions
//TODO add Stone + interactions
//TODO make screen size bigger
//TODO make new labfile.txt
//TODO mess around with click size
//TODO the circle explosion since fire uses a while loop that makes it "flicker" the circle should first make a circle in the array and then i could use a while loop to determine its size so if it hasn't reached x numbeer a counter will grow and it will expand 
import java.awt.*;
import java.util.*;

public class ParticleLab {
    // static final int NBR_ROWS = 300; // 180
    // static final int NBR_COLS = 400; // 180
    // static final int CELL_SIZE = 1200; // 800
    static final int NBR_ROWS = 220; // 180
    static final int NBR_COLS = 240; // 180
    static final int CELL_SIZE = 1100; // 800

    static final String FILE_NAME = "ParticleLabFile.txt"; // This is the name of the input file.
    static final String NEW_FILE_NAME = "ParticleLabFileGreatPainting.txt"; // This is the name of the file you are
                                                                            // saving.

    // add constants for particle types here
    public static final int EMPTY = 0;
    public static final int METAL = 1;
    public static final int SAND = 2;
    public static final int WATER = 3;
    public static final int ICE = 4;
    public static final int OIL = 5;
    public static final int VAPOR = 6;
    public static final int SOIL = 7;
    public static final int SEEWEED = 8;
    public static final int GRASS = 9;
    public static final int STONE = 10;
    public static final int LAVA = 11;
    public static final int FIRE = 12;
    public static final int FUSE = 13;
    public static final int C4 = 14;
    public static final int SPONGE = 15;
    public static final int WOOD = 16;
    public static final int CRYOFREEZE = 17;
    public static final int GENERATOR = 18;
    public static final int DESTRUCTOR = 19;
    public static final int SAVEFILE = 20;
    public static final int GRAVITY = 21;
    public static final int CLEAR = 22;
    public static final int RESET = 23;
    public static final int EXPLOSION = 24;
    // non particle grid types
    public static final int GENERATOR_CHANCE = 5; // 5% chance

    // do not add any more global fields
    private int row = 0;
    private int col = 0;
    private boolean gravity = true;
    private int[][] particleGrid;
    private LabDisplay display;

    // ---------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("================= Starting Program =================");
        System.out.println("ROWS: " + NBR_ROWS + "\nCOLS: " + NBR_COLS + "\nCELL_SIZE: " + CELL_SIZE + "\n");

        ParticleLab lab = new ParticleLab(NBR_ROWS, NBR_COLS); // creates the object
        lab.run();
    }

    // add gravity to particle

    // SandLab constructor - ran when the above lab object is created
    public ParticleLab(int numRows, int numCols) {
        String[] names = new String[25];

        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[SAND] = "Sand";
        names[WATER] = "Water";
        names[ICE] = "Ice";
        names[OIL] = "Oil";
        names[VAPOR] = "Vapor";
        names[SOIL] = "Soil";
        names[SEEWEED] = "Seeweed";
        names[GRASS] = "Grass";
        names[STONE] = "Stone";
        names[LAVA] = "Lava";
        names[FIRE] = "Fire";
        names[FUSE] = "Fuse";
        names[C4] = "C4";
        names[SPONGE] = "Sponge";
        names[WOOD] = "Wood";
        names[CRYOFREEZE] = "Cryofreeze";
        names[GENERATOR] = " Generator ";
        names[DESTRUCTOR] = "Destructor ";
        names[SAVEFILE] = "  Save File";
        names[GRAVITY] = "   Gravity  ";
        names[CLEAR] = "     Clear    ";
        names[RESET] = "Reset";
        names[EXPLOSION] = "Explosion";

        display = new LabDisplay("SandLab", numRows, numCols, names); // uses the LabDisplay.class file
        particleGrid = new int[numRows][numCols];

        if (FILE_NAME != "") {
            System.out.println("Attempting to load: " + FILE_NAME);
            particleGrid = ParticleLabFiles.readFile(FILE_NAME);
        }

    }

    // called when the user clicks on a location using the given tool
    private void locationClicked(int row, int col, int tool) {
        // insert code here
        if (tool == EMPTY) {

            particleGrid[row][col] = EMPTY;

        }

        if (tool == METAL) {

            particleGrid[row][col] = METAL; // an example of how to display a named Java color

        }
        if (tool == SAND) {

            particleGrid[row][col] = SAND; //

        }
        if (tool == WATER) {

            particleGrid[row][col] = WATER;//

        }
        if (tool == ICE) {

            particleGrid[row][col] = ICE;//

        }
        if (tool == OIL) {

            particleGrid[row][col] = OIL;//

        }
        if (tool == VAPOR) {

            particleGrid[row][col] = VAPOR;

        }
        if (tool == SOIL) {

            particleGrid[row][col] = SOIL;//

        }
        if (tool == SEEWEED) {

            particleGrid[row][col] = SEEWEED;//

        }
        if (tool == GRASS) {

            particleGrid[row][col] = GRASS;//

        }
        if (tool == STONE) {

            particleGrid[row][col] = STONE;//

        }
        if (tool == LAVA) {

            particleGrid[row][col] = LAVA;

        }
        if (tool == FIRE) {

            particleGrid[row][col] = FIRE;

        }
        if (tool == FUSE) {

            particleGrid[row][col] = FUSE;

        }
        if (tool == C4) {

            particleGrid[row][col] = C4;

        }
        if (tool == SPONGE) {

            particleGrid[row][col] = SPONGE;

        }
        if (tool == WOOD) {

            particleGrid[row][col] = WOOD;

        }
        if (tool == CRYOFREEZE) {

            particleGrid[row][col] = CRYOFREEZE;//

        }
        if (tool == GENERATOR) {

            particleGrid[row][col] = GENERATOR;//

        }
        if (tool == DESTRUCTOR) {

            particleGrid[row][col] = DESTRUCTOR;//

        }
        if (tool == SAVEFILE) {

            ParticleLabFiles.writeFile(particleGrid, NEW_FILE_NAME);

        }
        if (tool == GRAVITY) {

            // try to get the jbutton toggle boolean to work

            gravity = !gravity;

        }
        if (tool == RESET) {

            particleGrid = ParticleLabFiles.readFile(FILE_NAME);

        }
        if (tool == CLEAR) {

            // bassically recreating the object array
            particleGrid = new int[NBR_ROWS][NBR_COLS];

        }
        if (tool == EXPLOSION) {

            particleGrid[row][col] = EXPLOSION;

        }
    }

    // Examines each element of the 2D particleGrid and paints a color onto the
    // display
    public void updateDisplay() {

        Color desertSand = new Color(187, 154, 113);
        Color iceColor = new Color(214, 236, 239);
        Color oil = new Color(223, 216, 85);
        Color vapor = new Color(212, 241, 249);
        Color soil = new Color(101, 67, 33);
        Color seaweed = new Color(34, 139, 34);
        Color c4 = new Color(187, 255, 19);
        Color wood = new Color(186, 140, 99);
        Color cryofreeze = new Color(173, 216, 230);

        for (int r = 0; r < NBR_ROWS; r++) {
            for (int c = 0; c < NBR_COLS; c++) {

                if (particleGrid[r][c] == EMPTY) {

                    display.setColor(r, c, Color.BLACK);

                }

                else if (particleGrid[r][c] == METAL) {

                    display.setColor(r, c, Color.LIGHT_GRAY);

                } else if (particleGrid[r][c] == SAND) {

                    display.setColor(r, c, desertSand);

                } else if (particleGrid[r][c] == WATER) {

                    display.setColor(r, c, Color.BLUE);

                } else if (particleGrid[r][c] == ICE) {

                    display.setColor(r, c, iceColor);

                } else if (particleGrid[r][c] == OIL) {

                    display.setColor(r, c, oil);

                } else if (particleGrid[r][c] == VAPOR) {

                    display.setColor(r, c, vapor);

                } else if (particleGrid[r][c] == SOIL) {

                    display.setColor(r, c, soil);

                } else if (particleGrid[r][c] == SEEWEED) {

                    display.setColor(r, c, seaweed);

                } else if (particleGrid[r][c] == GRASS) {

                    display.setColor(r, c, Color.green);

                } else if (particleGrid[r][c] == STONE) {

                    display.setColor(r, c, Color.DARK_GRAY);

                } else if (particleGrid[r][c] == LAVA) {

                    display.setColor(r, c, Color.ORANGE);

                } else if (particleGrid[r][c] == FIRE) {

                    display.setColor(r, c, Color.RED);

                } else if (particleGrid[r][c] == FUSE) {

                    display.setColor(r, c, Color.WHITE);

                } else if (particleGrid[r][c] == C4) {

                    display.setColor(r, c, c4);

                } else if (particleGrid[r][c] == SPONGE) {

                    display.setColor(r, c, Color.YELLOW);

                } else if (particleGrid[r][c] == WOOD) {

                    display.setColor(r, c, wood);

                } else if (particleGrid[r][c] == CRYOFREEZE) {

                    display.setColor(r, c, cryofreeze);

                } else if (particleGrid[r][c] == GENERATOR) {

                    display.setColor(r, c, Color.PINK);

                } else if (particleGrid[r][c] == DESTRUCTOR) {

                    display.setColor(r, c, Color.CYAN);

                } else if (particleGrid[r][c] == EXPLOSION) {

                    display.setColor(r, c, Color.ORANGE);

                }

            }

        }
    }

    // #######################################################################################################################################################################
    // *oil processing*
    // #######################################################################################################################################################################
    public void proccesOil(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        if (particleGrid[row][col] == OIL) {

            if (particleGrid[rp1][col] == EMPTY) {

                particleGrid[rp1][col] = OIL;
                particleGrid[row][col] = EMPTY;

            }
            // left
            if (particleGrid[row][cm1] == EMPTY) {

                particleGrid[row][cm1] = particleGrid[row][col];
                particleGrid[row][col] = EMPTY;

            }
            // right
            if (particleGrid[row][cp1] == EMPTY) {

                particleGrid[row][cp1] = particleGrid[row][col];
                particleGrid[row][col] = EMPTY;

            }
        }
    }
    // #######################################################################################################################################################################
    // *Oil end processing*
    // #######################################################################################################################################################################

    // #######################################################################################################################################################################
    // *Sand processing*
    // #######################################################################################################################################################################

    // this part spawns the particles
    // sand left 15 middle 70 right 15
    // wateer 25 50 25
    // vapor up
    // called repeatedly.
    // causes one random particle to maybe do something.&& particleGrid[row][col] !=
    // METAL && particleGrid[rp1][col] != METAL

    public void processSand(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        int random = IR4.getRandomNumber(1, 10);
        if (particleGrid[row][col] == SAND) {

            if (particleGrid[rp1][col] == EMPTY) {

                particleGrid[rp1][col] = SAND;
                particleGrid[row][col] = EMPTY;

            } else if (random <= 5 && particleGrid[rp1][cp1] == EMPTY && particleGrid[row][cp1] != METAL) {

                particleGrid[rp1][cp1] = SAND;
                particleGrid[row][col] = EMPTY;

            } else if (random >= 5 && particleGrid[rp1][cm1] == EMPTY && particleGrid[row][cm1] != METAL) {

                particleGrid[rp1][cm1] = SAND;
                particleGrid[row][col] = EMPTY;
            }

            processSandInteractions(row, col, rp1, cp1, cm1, rm1);

        }

    }

    public void processSandInteractions(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        if (particleGrid[rp1][col] == WATER) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][col];// water to sand
            particleGrid[rp1][col] = tempararyPixel;// sand to water

        }

        if (particleGrid[rp1][cp1] == WATER) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cp1];// water to sand
            particleGrid[rp1][cp1] = tempararyPixel;// sand to water

        }

        if (particleGrid[rp1][cm1] == WATER) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cm1];// water to sand
            particleGrid[rp1][cm1] = tempararyPixel;// sand to water

        }
        if (particleGrid[rp1][col] == OIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][col];// OIL to sand
            particleGrid[rp1][col] = tempararyPixel;// sand to OIL

        }

        if (particleGrid[rp1][cp1] == OIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cp1];// OIL to sand
            particleGrid[rp1][cp1] = tempararyPixel;// sand to OIL

        }

        if (particleGrid[rp1][cm1] == OIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cm1];// OIL to sand
            particleGrid[rp1][cm1] = tempararyPixel;// sand to OIL

        }

        if (particleGrid[rp1][col] == SOIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][col];// OIL to sand
            particleGrid[rp1][col] = tempararyPixel;// sand to OIL

        }

        if (particleGrid[rp1][cp1] == SOIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cp1];// OIL to sand
            particleGrid[rp1][cp1] = tempararyPixel;// sand to OIL

        }

        if (particleGrid[rp1][cm1] == SOIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cm1];// OIL to sand
            particleGrid[rp1][cm1] = tempararyPixel;// sand to OIL

        }

    }
    // #######################################################################################################################################################################
    // *End of Sand processing*
    // #######################################################################################################################################################################
    // #######################################################################################################################################################################
    // *Water processing*
    // #######################################################################################################################################################################

    public void processWater(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        int randomNumber = IR4.getRandomNumber(0, 10);

        if (particleGrid[row][col] == WATER) {

            if (particleGrid[rp1][col] == EMPTY) {

                particleGrid[rp1][col] = WATER;
                particleGrid[row][col] = EMPTY;

            }
            // left
            else if (randomNumber >= 0 && randomNumber <= 5 && particleGrid[row][cm1] == EMPTY) {

                particleGrid[row][cm1] = particleGrid[row][col];
                particleGrid[row][col] = EMPTY;

            }
            // right
            else if (randomNumber >= 6 && randomNumber <= 10 && particleGrid[row][cp1] == EMPTY) {

                particleGrid[row][cp1] = particleGrid[row][col];
                particleGrid[row][col] = EMPTY;

            }
            // proccessOilInteraction
            proccessWaterAndOilInteraction(row, col, rp1, cp1, cm1, rm1);
        }

    }

    // have to refine this and comment
    public void proccessWaterAndOilInteraction(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        // DON'T FORGET TO COMMENT AND DESCRIBE WHAT THIS DOES
        if (particleGrid[rp1][col] == OIL) {

            int tempararyPixel = particleGrid[row][col];
            particleGrid[row][col] = particleGrid[rp1][col];
            particleGrid[rp1][col] = tempararyPixel;

        }
        if (particleGrid[rp1][cp1] == OIL) {

            int tempararyPixel = particleGrid[row][col];
            particleGrid[row][col] = particleGrid[rp1][cp1];
            particleGrid[rp1][cp1] = tempararyPixel;

        }
        if (particleGrid[rp1][cm1] == OIL) {

            int tempararyPixel = particleGrid[row][col];
            particleGrid[row][col] = particleGrid[rp1][cm1];
            particleGrid[rp1][cm1] = tempararyPixel;
        }
        if (particleGrid[row][cp1] == OIL) {

            int tempararyPixel = particleGrid[row][col];
            particleGrid[row][col] = particleGrid[row][cp1];
            particleGrid[row][cp1] = tempararyPixel;
        }

        if (particleGrid[row][cm1] == OIL) {

            int tempararyPixel = particleGrid[row][col];
            particleGrid[row][col] = particleGrid[row][cm1];
            particleGrid[row][cm1] = tempararyPixel;

        }
    }
    // #######################################################################################################################################################################
    // *End of water processing*
    // #######################################################################################################################################################################

    // #######################################################################################################################################################################
    // *ice processing*
    // #######################################################################################################################################################################

    public void proccessICE(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        if (particleGrid[row][col] == ICE && particleGrid[row][col] != METAL) {

            if (particleGrid[rp1][col] == WATER) {

                // particleGrid[row][col] = particleGrid[rp1][col];
                particleGrid[rp1][col] = ICE;

            }
            if (particleGrid[rm1][col] == WATER) {

                // particleGrid[row][col] = particleGrid[rm1][cm1];
                particleGrid[rm1][col] = ICE;

            }
            if (particleGrid[row][cp1] == WATER) {

                // particleGrid[row][col] = particleGrid[rp1][cp1];
                particleGrid[rp1][cp1] = ICE;

            }
            if (particleGrid[rp1][cm1] == WATER) {

                // particleGrid[row][col] = particleGrid[rp1][cm1];
                particleGrid[rp1][cm1] = ICE;

            }

            if (particleGrid[rp1][col] == VAPOR) {

                particleGrid[rp1][col] = WATER;

            }

        }

    }

    // #######################################################################################################################################################################
    // *end of Ice processing*
    // #######################################################################################################################################################################
    // #######################################################################################################################################################################
    // *start of Generator processing*
    // #######################################################################################################################################################################
    public void proccessGenerator(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        int randomNumber = IR4.getRandomNumber(1, 500);
        // rp1 = rm1
        if (particleGrid[row][col] == GENERATOR) {
            if (!(particleGrid[rm1][col] == EMPTY || particleGrid[rm1][col] == METAL || particleGrid[rm1][col] == ICE
                    || particleGrid[rm1][col] == GENERATOR || particleGrid[rm1][col] == DESTRUCTOR)) {

                if (randomNumber <= GENERATOR_CHANCE) {
                    particleGrid[rp1][col] = particleGrid[rm1][col];
                }
                // System.out.println(randomNumber);
            }
        }
    }

    public void proccessDestructor(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        // rp1 = rm1
        if (particleGrid[row][col] == DESTRUCTOR) {
            if (!(particleGrid[rm1][col] == EMPTY || particleGrid[rm1][col] == METAL || particleGrid[rm1][col] == ICE
                    || particleGrid[rm1][col] == GENERATOR || particleGrid[rm1][col] == DESTRUCTOR)) {

                particleGrid[rm1][col] = VAPOR;
                // System.out.println(randomNumber);
            }
        }
    }

    public void proccessSoil(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        int random = IR4.getRandomNumber(1, 10);
        if (particleGrid[row][col] == SOIL) {

            if (random <= 6 && particleGrid[rp1][col] == EMPTY) {

                particleGrid[rp1][col] = SOIL;
                particleGrid[row][col] = EMPTY;
                return;
            }

            else if (random >= 6 && random <= 8 && particleGrid[rp1][cp1] == EMPTY && particleGrid[row][cp1] != METAL) {
                particleGrid[rp1][cp1] = SOIL;
                particleGrid[row][col] = EMPTY;
            } else if (random >= 8 && random <= 10 && particleGrid[rp1][cm1] == EMPTY
                    && particleGrid[row][cm1] != METAL) {
                particleGrid[rp1][cm1] = SOIL;
                particleGrid[row][col] = EMPTY;
            }

            if (particleGrid[rp1][col] == WATER) {

                int tempararyPixel = particleGrid[row][col];// save sand place
                particleGrid[row][col] = particleGrid[rp1][col];// OIL to sand
                particleGrid[rp1][col] = tempararyPixel;// sand to OIL
    
            }
    
            if (particleGrid[rp1][cp1] == WATER) {
    
                int tempararyPixel = particleGrid[row][col];// save sand place
                particleGrid[row][col] = particleGrid[rp1][cp1];// OIL to sand
                particleGrid[rp1][cp1] = tempararyPixel;// sand to OIL
    
            }
    
            if (particleGrid[rp1][cm1] == WATER) {
    
                int tempararyPixel = particleGrid[row][col];// save sand place
                particleGrid[row][col] = particleGrid[rp1][cm1];// OIL to sand
                particleGrid[rp1][cm1] = tempararyPixel;// sand to OIL
    
            }
            if (particleGrid[rp1][col] == WATER) {

                particleGrid[rp1][col] = EMPTY;

            }
            if (particleGrid[rm1][col] == WATER) {

                particleGrid[rm1][col] = EMPTY;

            }

            if (particleGrid[row][cm1] == WATER) {

                particleGrid[row][cm1] = EMPTY;

            }
            if (particleGrid[row][cp1] == WATER) {

                particleGrid[row][cp1] = EMPTY;

            }
        }
        

    }

    public void processSeaweed(int row, int col, int rp1, int cp1, int cm1, int rm1) {

    }

    public void processGrass(int row, int col, int rp1, int cp1, int cm1, int rm1) {
int random = IR4.getRandomNumber(1,250);
        if (particleGrid[row][col] == GRASS) {
            if (particleGrid[rp1][cm1] == SOIL || particleGrid[rp1][col] == SAND && particleGrid[row][col] == EMPTY) {

                if (particleGrid[rm1][col] == WATER) {

                    // particleGrid[row][col] = particleGrid[rp1][col];
                    particleGrid[rm1][col] = GRASS;

                    if (particleGrid[rp1][col] == GRASS) {

                        // particleGrid[row][col] = particleGrid[rm1][cm1];
                        particleGrid[rm1][col] = GRASS;

                        
                    }
                }
            }
            if (random == 250 && particleGrid[rm1][col] == EMPTY && particleGrid[rp1][col] == GRASS) {

                // particleGrid[row][col] = particleGrid[rp1][cp1];
                particleGrid[rm1][col] = GRASS;

            }
        }
    }

    public void processStone(int row, int col, int rp1, int cp1, int cm1, int rm1) {
        int random = IR4.getRandomNumber(1, 10);
        if (particleGrid[row][col] == STONE) {

            if (particleGrid[rp1][col] == EMPTY) {

                particleGrid[rp1][col] = STONE;
                particleGrid[row][col] = EMPTY;

            } else if (random == 9 && particleGrid[rp1][cp1] == EMPTY && particleGrid[row][cp1] != METAL) {

                particleGrid[rp1][cp1] = STONE;
                particleGrid[row][col] = EMPTY;

            } else if (random == 10 && particleGrid[rp1][cm1] == EMPTY && particleGrid[row][cm1] != METAL) {

                particleGrid[rp1][cm1] = STONE;
                particleGrid[row][col] = EMPTY;
            }
            processStoneInteractions(row, col, rp1, cp1, cm1, rm1);
        }

    }

    public void processStoneInteractions(int row, int col, int rp1, int cp1, int cm1, int rm1) {
        int random = IR4.getRandomNumber(1, 50);

        if (random < 10 && particleGrid[rp1][col] == SAND) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][col];// water to sand
            particleGrid[rp1][col] = tempararyPixel;// sand to water

        }

        else if (random == 49 && particleGrid[rp1][cp1] == SAND) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cp1];// water to sand
            particleGrid[rp1][cp1] = tempararyPixel;// sand to water

        }

        else if (random == 50 && particleGrid[rp1][cm1] == SAND) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cm1];// water to sand
            particleGrid[rp1][cm1] = tempararyPixel;// sand to water

        }
        if (particleGrid[rp1][col] == WATER) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][col];// water to sand
            particleGrid[rp1][col] = tempararyPixel;// sand to water

        }

        if (particleGrid[rp1][cp1] == WATER) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cp1];// water to sand
            particleGrid[rp1][cp1] = tempararyPixel;// sand to water

        }

        if (particleGrid[rp1][cm1] == WATER) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cm1];// water to sand
            particleGrid[rp1][cm1] = tempararyPixel;// sand to water

        }
        if (particleGrid[rp1][col] == OIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][col];// OIL to sand
            particleGrid[rp1][col] = tempararyPixel;// sand to OIL

        }

        if (particleGrid[rp1][cp1] == OIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cp1];// OIL to sand
            particleGrid[rp1][cp1] = tempararyPixel;// sand to OIL

        }

        if (particleGrid[rp1][cm1] == OIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cm1];// OIL to sand
            particleGrid[rp1][cm1] = tempararyPixel;// sand to OIL

        }
        if (random < 25 &&particleGrid[rp1][col] == SOIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][col];// OIL to sand
            particleGrid[rp1][col] = tempararyPixel;// sand to OIL

        }

        if (random == 49 &&particleGrid[rp1][cp1] == SOIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cp1];// OIL to sand
            particleGrid[rp1][cp1] = tempararyPixel;// sand to OIL

        }

        if (random == 50 &&particleGrid[rp1][cm1] == SOIL) {

            int tempararyPixel = particleGrid[row][col];// save sand place
            particleGrid[row][col] = particleGrid[rp1][cm1];// OIL to sand
            particleGrid[rp1][cm1] = tempararyPixel;// sand to OIL

        }
    }

    public void proccessLava(int row, int col, int rp1, int cp1, int cm1, int rm1) {

    }

    public void processFire(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        int num = IR4.getRandomNumber(1, 5);

        if (particleGrid[row][col] == FIRE) {
            // i wanted this to follow the mouse and after a short distance it will
            // dissapear since theres no fuel for the fire
            // try to experiemtn with 3d array scratch this
            if (num != 5 && particleGrid[rm1][col] == EMPTY || particleGrid[rm1][col] == METAL) {

                particleGrid[rm1][col] = FIRE;
                particleGrid[row][col] = EMPTY;

            } else {

                particleGrid[row][col] = EMPTY;

            }

            // checks 4 axis to turn water into vapor
            if (particleGrid[rp1][col] == WATER || particleGrid[rm1][col] == WATER || particleGrid[row][cm1] == WATER
                    || particleGrid[row][cp1] == WATER) {

                particleGrid[rm1][col] = VAPOR;
                // particleGrid[row][col] = EMPTY;
            }

            if (particleGrid[rm1][col] == EXPLOSION) {

                particleGrid[rm1][col] = FIRE;

            } else if (particleGrid[rp1][col] == EXPLOSION) {

                particleGrid[rp1][col] = FIRE;

            }
            if (particleGrid[rp1][col] == FUSE) {

                // particleGrid[row][col] = particleGrid[rp1][col];
                particleGrid[rp1][col] = FIRE;

            }
            if (particleGrid[rm1][col] == FUSE) {

                // particleGrid[row][col] = particleGrid[rm1][cm1];
                particleGrid[rm1][col] = FIRE;

            }
            if (particleGrid[row][cp1] == FUSE) {

                // particleGrid[row][col] = particleGrid[rp1][cp1];
                particleGrid[rp1][cp1] = FIRE;

            }
            if (particleGrid[rp1][cm1] == FUSE) {

                // particleGrid[row][col] = particleGrid[rp1][cm1];
                particleGrid[rp1][cm1] = FIRE;

            }
            if (particleGrid[rp1][col] == OIL) {

                // particleGrid[row][col] = particleGrid[rp1][col];
                particleGrid[rp1][col] = FIRE;

            }
            if (particleGrid[rm1][col] == OIL) {

                // particleGrid[row][col] = particleGrid[rm1][cm1];
                particleGrid[rm1][col] = FIRE;

            }
            if (particleGrid[row][cp1] == OIL) {

                // particleGrid[row][col] = particleGrid[rp1][cp1];
                particleGrid[rp1][cp1] = FIRE;

            }
            if (particleGrid[rp1][cm1] == OIL) {

                // particleGrid[row][col] = particleGrid[rp1][cm1];
                particleGrid[rp1][cm1] = FIRE;

            }

        }

    }

    public void processFuse(int row, int col, int rp1, int cp1, int cm1, int rm1) {
        // TODO c4 replicates and spreads out

        if (particleGrid[row][col] == FUSE) {

            if (particleGrid[rp1][col] == FIRE
                    || particleGrid[rm1][col] == FIRE
                    || particleGrid[row][cp1] == FIRE
                    || particleGrid[row][cm1] == FIRE
                    || particleGrid[rm1][cp1] == FIRE
                    || particleGrid[rm1][cm1] == FIRE
                    || particleGrid[rp1][cm1] == FIRE
                    || particleGrid[rm1][cp1] == FIRE) {

                particleGrid[row][col] = FIRE;

            }

        }

    }

    public void processC4(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        // make while loop that detects if radius is equal to randome number
        if (particleGrid[row][col] == C4) {

            if (particleGrid[rp1][col] == EXPLOSION
                    || particleGrid[rm1][col] == EXPLOSION
                    || particleGrid[row][cp1] == EXPLOSION
                    || particleGrid[row][cm1] == EXPLOSION
                    || particleGrid[rm1][cp1] == EXPLOSION
                    || particleGrid[rm1][cm1] == EXPLOSION
                    || particleGrid[rp1][cm1] == EXPLOSION
                    || particleGrid[rm1][cp1] == EXPLOSION) {

                particleGrid[row][col] = EXPLOSION;

                processExplosion(row, col, rp1, cp1, cm1, rm1);

            } else if (particleGrid[rp1][col] == FIRE
                    || particleGrid[rm1][col] == FIRE
                    || particleGrid[row][cp1] == FIRE
                    || particleGrid[row][cm1] == FIRE
                    || particleGrid[rm1][cp1] == FIRE
                    || particleGrid[rm1][cm1] == FIRE
                    || particleGrid[rp1][cm1] == FIRE
                    || particleGrid[rm1][cp1] == FIRE) {

                particleGrid[rm1][col] = EXPLOSION;
                processExplosion(row, col, rp1, cp1, cm1, rm1);

            }

        }
    }

    // TODO make an explosion method and see ifits neccessary
    public void processExplosion(int row, int col, int rp1, int cp1, int cm1, int rm1) {
        int random = IR4.getRandomNumber(1, 99);

        // make random number check to see if it passes to make an explosion
        if (particleGrid[row][col] == EXPLOSION) {

            if (particleGrid[rp1][col] == EXPLOSION
                    || particleGrid[rm1][col] == EXPLOSION
                    || particleGrid[row][cp1] == EXPLOSION
                    || particleGrid[row][cm1] == EXPLOSION
                    || particleGrid[rm1][cp1] == EXPLOSION
                    || particleGrid[rm1][cm1] == EXPLOSION
                    || particleGrid[rp1][cm1] == EXPLOSION
                    || particleGrid[rm1][cp1] == EXPLOSION) {

                particleGrid[row][col] = FIRE;
                particleGrid[rp1][cp1] = EXPLOSION;
                particleGrid[rp1][cm1] = EXPLOSION;
                particleGrid[rm1][cp1] = EXPLOSION;
                particleGrid[rm1][cm1] = EXPLOSION;
                particleGrid[rp1][col] = FIRE;
                particleGrid[row][cp1] = FIRE;
                particleGrid[rm1][col] = FIRE;
                particleGrid[row][cm1] = FIRE;

                // particleGrid[rp1][cp1] = FIRE;
                // particleGrid[rp1][cm1] = FIRE;
                // particleGrid[rm1][cp1] = FIRE;
                // particleGrid[rm1][cm1] = FIRE;
            }
            if (random > 80 && particleGrid[row][col] == EXPLOSION) {

                particleGrid[row][col] = EMPTY;

            } else if (random > 40 && particleGrid[row][col] == EXPLOSION) {

                particleGrid[row][col] = FIRE;

            }

        }

    }

    public void processSponge(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        if (particleGrid[row][col] == SPONGE) {
            if (particleGrid[rp1][col] == WATER) {

                particleGrid[rp1][col] = EMPTY;

            }
            if (particleGrid[rm1][col] == WATER) {

                particleGrid[rm1][col] = EMPTY;

            }

            if (particleGrid[row][cm1] == WATER) {

                particleGrid[row][cm1] = EMPTY;

            }
            if (particleGrid[row][cp1] == WATER) {

                particleGrid[row][cp1] = EMPTY;

            }
        }
    }

    public void processWood(int row, int col, int rp1, int cp1, int cm1, int rm1) {
        if (particleGrid[row][col] == WOOD) {

            if (particleGrid[rp1][col] == FIRE) {
                particleGrid[row][col] = FIRE;

            }
            if (particleGrid[rm1][col] == FIRE) {
                particleGrid[row][col] = FIRE;

            }
            if (particleGrid[row][cp1] == FIRE) {
                particleGrid[row][col] = FIRE;

            }
            if (particleGrid[row][cm1] == FIRE) {
                particleGrid[row][col] = FIRE;

            }
            if (particleGrid[rm1][cp1] == FIRE) {
                particleGrid[row][col] = FIRE;

            }
            if (particleGrid[rm1][cm1] == FIRE) {
                particleGrid[row][col] = FIRE;

            }
            if (particleGrid[rp1][cm1] == FIRE) {
                particleGrid[row][col] = FIRE;

            }
            if (particleGrid[rm1][cp1] == FIRE) {
                particleGrid[row][col] = FIRE;

            }

        }
    }

    public void processCryofreeze(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        int randomNumber = IR4.getRandomNumber(0, 10);
        int cryoRandNbr = IR4.getRandomNumber(0, 200);

        if (particleGrid[row][col] == CRYOFREEZE) {

            if (particleGrid[rp1][col] == EMPTY) {

                particleGrid[rp1][col] = CRYOFREEZE;
                particleGrid[row][col] = EMPTY;

            }
            // left
            else if (randomNumber >= 5 && randomNumber <= 7 && particleGrid[row][cm1] == EMPTY) {

                particleGrid[row][cm1] = particleGrid[row][col];
                particleGrid[row][col] = EMPTY;

            }
            // right
            else if (randomNumber >= 7 && randomNumber <= 10 && particleGrid[row][cp1] == EMPTY) {

                particleGrid[row][cp1] = particleGrid[row][col];
                particleGrid[row][col] = EMPTY;

            }

            else if (particleGrid[rp1][col] != EMPTY && cryoRandNbr > 195 && cryoRandNbr < 200
                    && particleGrid[rp1][col] != CRYOFREEZE) {

                particleGrid[row][col] = ICE;

            }

        }

        // acts like sand and set a timer for it to turn into ice
    }

    // #######################################################################################################################################################################
    // *end of Generator processing*
    // #######################################################################################################################################################################
    // #######################################################################################################################################################################
    // *start of vapor processing*
    // #######################################################################################################################################################################
    public void processWaterVapor(int row, int col, int rp1, int cp1, int cm1, int rm1) {

        int num = IR4.getRandomNumber(1, 100);

        if (particleGrid[row][col] == VAPOR) {

            if (num >= 1 && num <= 33 && particleGrid[row][cp1] == EMPTY) {

                particleGrid[row][cp1] = VAPOR;
                particleGrid[row][col] = EMPTY;

            } else if (num >= 33 && num <= 66 && particleGrid[row][cm1] == EMPTY) {

                particleGrid[row][cm1] = VAPOR;
                particleGrid[row][col] = EMPTY;

            } else if (num >= 66 && num <= 99 && particleGrid[rm1][col] == EMPTY) {

                particleGrid[rm1][col] = VAPOR;
                particleGrid[row][col] = EMPTY;

            } else if (num == 100 && particleGrid[row][col] == VAPOR) {

                // if(particleGrid[row][col] == VAPOR){
                particleGrid[row][col] = EMPTY;

                // }

            }

        }

    }

    // #######################################################################################################################################################################
    // *end of vapor processing*
    // #######################################################################################################################################################################

    // #######################################################################################################################################################################
    // *Wrapping processing*
    // #######################################################################################################################################################################

    public int rowPlusOne(int rp1) {

        if (row == particleGrid.length - 1) {

            rp1 = 0;

        } else {

            rp1 = row + 1;

        }

        return rp1;

    }

    public int rowMinusOne(int rm1) {

        if (row <= 0) {

            rm1 = NBR_ROWS - 1;

        } else {

            rm1 = row - 1;

        }

        return rm1;

    }

    public int columnPlusOne(int cp1) {

        if (col >= NBR_COLS - 1) {

            cp1 = 0;

        } else {

            cp1 = col + 1;

        }

        return cp1;
    }

    public int columnMinusOne(int cm1) {

        if (col <= 0) {

            cm1 = NBR_COLS - 1;

        } else {

            cm1 = col - 1;

        }

        return cm1;
    }

    // #######################################################################################################################################################################
    // *end of wrapping processing*
    // #######################################################################################################################################################################

    public void step() {

        // insert code here
        Random random = new Random();

        row = random.nextInt(particleGrid.length); //
        col = random.nextInt(particleGrid[row].length);

        int rp1 = 0;
        int rm1 = 0;
        int cp1 = 0;
        int cm1 = 0;
        // switching the values of variables so it stores the proper value
        if (!gravity) {
            rp1 = rowMinusOne(rm1);

            rm1 = rowPlusOne(rp1);

            cp1 = columnPlusOne(cp1);

            cm1 = columnMinusOne(cm1);

        } else {

            rp1 = rowPlusOne(rp1);

            rm1 = rowMinusOne(rm1);

            cp1 = columnPlusOne(cp1);

            cm1 = columnMinusOne(cm1);

        }

        // In step() start to organize your code. When the random location is sand,
        // execute a processSand() function.

        processSand(row, col, rp1, cp1, cm1, rm1);
        processWater(row, col, rp1, cp1, cm1, rm1);
        proccessICE(row, col, rp1, cp1, cm1, rm1);
        proccesOil(row, col, rp1, cp1, cm1, rm1);
        processSponge(row, col, rp1, cp1, cm1, rm1);
        processWaterVapor(row, col, rp1, cp1, cm1, rm1);
        proccessGenerator(row, col, rp1, cp1, cm1, rm1);
        proccessDestructor(row, col, rp1, cp1, cm1, rm1);
        proccessSoil(row, col, rp1, cp1, cm1, rm1);
        processFire(row, col, rp1, cp1, cm1, rm1);
        processCryofreeze(row, col, rp1, cp1, cm1, rm1);
        processStone(row, col, rp1, cp1, cm1, rm1);
        processC4(row, col, rp1, cp1, cm1, rm1);
        processFuse(row, col, rp1, cp1, cm1, rm1);
        processExplosion(row, col, rp1, cp1, cm1, rm1);
        processWood(row, col, rp1, cp1, cm1, rm1);
        processGrass(row, col, rp1, cp1, cm1, rm1);
    }

    ////////////////////////////////////////////////////
    // DO NOT modify anything below here!!! /////////////
    ////////////////////////////////////////////////////

    public void run() {
        while (true) {
            for (int i = 0; i < display.getSpeed(); i++) {
                step();
            }
            updateDisplay();
            display.repaint();
            display.pause(1); // wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null) // test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }

    public int getRandomNumber(int low, int high) {
        return (int) (Math.random() * (high - low)) + low;
    }

    public static int getNbrRows() {
        return NBR_ROWS;
    }

    public static int getNbrCols() {
        return NBR_COLS;
    }

    public static int getCellSize() {
        return CELL_SIZE;
    }
}