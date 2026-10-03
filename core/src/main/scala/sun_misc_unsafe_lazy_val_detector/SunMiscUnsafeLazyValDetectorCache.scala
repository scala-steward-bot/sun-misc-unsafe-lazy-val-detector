package sun_misc_unsafe_lazy_val_detector

import scala.collection.concurrent.TrieMap

private[sun_misc_unsafe_lazy_val_detector] final class SunMiscUnsafeLazyValDetectorCache[A] {
  private[sun_misc_unsafe_lazy_val_detector] val cache: TrieMap[A, List[(String, Int)]] =
    TrieMap.empty

  def getOrElseUpdateCache(
    key: A,
    computeValue: () => List[(String, Int)]
  ): List[(String, Int)] =
    cache.getOrElseUpdate(key, computeValue())
}
