package designPatterns.builder.computer;

public enum RAMSize {
        GB4(4),
        GB8(8),
        GB16(16),
        GB32(32),
        GB64(64),
        GB128(128);

        private final int sizeGB;

        RAMSize(int sizeGB){
            this.sizeGB = sizeGB;
        }
        public int getSizeGB(){
            return sizeGB;
        }
}
