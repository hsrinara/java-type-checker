package org.hsrinara.typechecker.custom;

import org.checkerframework.checker.units.qual.UnknownUnits;

@java.lang.annotation.Documented
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE_USE, java.lang.annotation.ElementType.TYPE_PARAMETER})
@org.checkerframework.framework.qual.TypeQualifier
@org.checkerframework.framework.qual.SubtypeOf({UnknownUnits.class})
public @interface Price {
}
