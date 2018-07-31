package net.opengis.indoorgml.iit;


public class OrientableSurfaceGml {

    private SurfacePropertyGml baseSurface;
    private SignGml orientation;

    public OrientableSurfaceGml(SurfacePropertyGml baseSurface, SignGml orientation) {
        this.baseSurface = baseSurface;
        this.orientation = orientation;
    }

    public SurfacePropertyGml getBaseSurface() {
        return baseSurface;
    }

    public void setBaseSurface(SurfacePropertyGml baseSurface) {
        this.baseSurface = baseSurface;
    }

    public SignGml getOrientation() {
        return orientation;
    }

    public void setOrientation(SignGml orientation) {
        this.orientation = orientation;
    }
}
