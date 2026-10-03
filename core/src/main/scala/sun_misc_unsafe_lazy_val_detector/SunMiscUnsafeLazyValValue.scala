package sun_misc_unsafe_lazy_val_detector

import sbt.util.CacheImplicits.{*, given}
import sbtcompat.PluginCompat.FileRef
import sjsonnew.JsonFormat

final case class SunMiscUnsafeLazyValValue(
  groupId: String,
  artifactId: String,
  version: String,
  path: FileRef,
  classNames: Seq[(String, Int)]
)

object SunMiscUnsafeLazyValValue {
  implicit val ordering: Ordering[SunMiscUnsafeLazyValValue] =
    Ordering.by(x => (x.groupId, x.artifactId, x.version))

  implicit val jsonFormatInstance: JsonFormat[SunMiscUnsafeLazyValValue] =
    sjsonnew.BasicJsonProtocol.caseClass5(
      apply,
      (x: SunMiscUnsafeLazyValValue) => Some((x.groupId, x.artifactId, x.version, x.path, x.classNames))
    )(
      "groupId",
      "artifactId",
      "version",
      "path",
      "classNames",
    )
}
