<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Velo
 *
 * @ORM\Table(name="velo", indexes={@ORM\Index(name="fk", columns={"idf"})})
 * @ORM\Entity
 */
class Velo
{
    /**
     * @var int
     *
     * @ORM\Column(name="idv", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idv;

    /**
     * @var string
     *
     * @ORM\Column(name="libellev", type="string", length=30, nullable=false)
     */
    private $libellev;

    /**
     * @var string
     *
     * @ORM\Column(name="taillev", type="string", length=30, nullable=false)
     */
    private $taillev;

    /**
     * @var string
     *
     * @ORM\Column(name="couleurv", type="string", length=30, nullable=false)
     */
    private $couleurv;

    /**
     * @var int|null
     *
     * @ORM\Column(name="rating", type="integer", nullable=true)
     */
    private $rating;

    /**
     * @var string|null
     *
     * @ORM\Column(name="image", type="blob", length=0, nullable=true)
     */
    private $image;

    /**
     * @var \Fournisseur
     *
     * @ORM\ManyToOne(targetEntity="Fournisseur")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idf", referencedColumnName="idf")
     * })
     */
    private $idf;


}
