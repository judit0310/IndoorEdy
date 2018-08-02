package net.opengis.indoorgml.iit;

import net.opengis.indoorgml.geometry.AbstractGeometry;
import net.opengis.indoorgml.geometry.Shell;
import net.opengis.indoorgml.geometry.Solid;

import java.io.Serializable;
import java.util.ArrayList;

public class SolidGml extends AbstractGeometry {
        private static int labelNumber = 1;
        private Shell exteriorShell;
        private ArrayList<Shell> interiorShell;

        public SolidGml() {
            // TODO Auto-generated constructor stub
            super.setGMLID( "SOLID" + (labelNumber++) );
            interiorShell = new ArrayList<Shell>();
        }

        public static int getLabelNumber() {
            return labelNumber;
        }

        public static void setLabelNumber(int labelNumber) {
            labelNumber = labelNumber;
        }

        public Shell getExteriorShell() {
            return exteriorShell;
        }

        public void setExteriorShell(Shell exteriorShell) {
            this.exteriorShell = exteriorShell;
        }

        public ArrayList<Shell> getInteriorShell() {
            return interiorShell;
        }

        public void setInteriorShell(ArrayList<Shell> interiorShell) {
            this.interiorShell = interiorShell;
        }
}

