public enum LandPurpose {
  AGRICULTURAL("земли сельскохозяйственного назначения"),
  SETTLEMENT("земли населенных пунктов"),
  INDUSTRIAL("земли промышленности");
  final String PURPOSE;

  LandPurpose(String purpose) {
    this.PURPOSE = purpose;
  }
}
