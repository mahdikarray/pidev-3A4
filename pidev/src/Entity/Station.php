<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Station
 *
 * @ORM\Table(name="station")
 * @ORM\Entity
 */
class Station
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_station", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idStation;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_station", type="string", length=30, nullable=false)
     */
    private $nomStation;

    /**
     * @var string|null
     *
     * @ORM\Column(name="longitude", type="decimal", precision=9, scale=6, nullable=true)
     */
    private $longitude;

    /**
     * @var string|null
     *
     * @ORM\Column(name="latitude", type="decimal", precision=8, scale=6, nullable=true)
     */
    private $latitude;

    /**
     * @var string
     *
     * @ORM\Column(name="gouvernorat", type="string", length=50, nullable=false)
     */
    private $gouvernorat;


}
