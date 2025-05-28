package practice.p2parallels

import scala.collection.parallel.CollectionConverters.seqIsParallelizable

object Parallels {
  def countNonEmpty(sq: Seq[String]): Int = sq.par.count(s => s.nonEmpty)
}
