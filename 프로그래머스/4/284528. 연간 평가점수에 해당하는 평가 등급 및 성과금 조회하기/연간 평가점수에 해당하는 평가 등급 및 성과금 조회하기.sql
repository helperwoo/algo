SELECT
    a.EMP_NO,
    a.EMP_NAME,
    IF(AVG(b.SCORE) >= 96, 'S',
       IF(AVG(b.SCORE) >= 90, 'A',
         IF(AVG(b.SCORE) >= 80, 'B', 'C')
        )
      ) AS GRADE,
    IF(AVG(b.SCORE) >= 96, a.SAL * 0.2,
       IF(AVG(b.SCORE) >= 90, a.SAL * 0.15,
         IF(AVG(b.SCORE) >= 80, a.SAL * 0.1, 0)
        )
      ) AS BONUS
FROM HR_EMPLOYEES a
LEFT JOIN HR_GRADE b
    ON a.EMP_NO = b.EMP_NO
GROUP BY a.EMP_NO
ORDER BY a.EMP_NO ASC

