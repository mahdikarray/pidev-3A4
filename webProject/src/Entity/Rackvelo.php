<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Rackvelo
 *
 * @ORM\Table(name="rackvelo", indexes={@ORM\Index(name="fk_idStation", columns={"id_station"})})
 * @ORM\Entity
 */
class Rackvelo
{
    /**
     * @var int
     *
     * @ORM\Column(name="Ref_rack", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $refRack;

    /**
     * @var int
     *
     * @ORM\Column(name="Capacite", type="integer", nullable=false)
     */
    private $capacite;

    /**
     * @var int
     *
     * @ORM\Column(name="modele", type="integer", nullable=false)
     */
    private $modele;

    /**
     * @var \Station
     *
     * @ORM\ManyToOne(targetEntity="Station")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_station", referencedColumnName="Id_station")
     * })
     */
    private $idStation;


}
